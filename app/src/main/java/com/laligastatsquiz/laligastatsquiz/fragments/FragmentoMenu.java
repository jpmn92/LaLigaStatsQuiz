package com.laligastatsquiz.laligastatsquiz.fragments;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.common.reflect.TypeToken;
import com.google.firebase.BuildConfig;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.gson.Gson;
import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.competiciones.ClubesInternacional;
import com.laligastatsquiz.laligastatsquiz.competiciones.Competicion;
import com.laligastatsquiz.laligastatsquiz.competiciones.LigaEuropea;
import com.laligastatsquiz.laligastatsquiz.competiciones.SeleccionesInternacional;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoRegister;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.laligastatsquiz.laligastatsquiz.tools.SessionManagement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FragmentoMenu extends Fragment implements View.OnClickListener {
    private static FragmentoMenu fragmentoMenu;

    Button btComenzar, btPuntuaciones;
    Spinner spinnerStats, spinnerLiga, spinnerTemporada, spinnerTipoCompeticion;
    ImageView ivImagenPrincipal;
    Resources res;
    FirebaseMethods firebaseMethods;
    Bundle params;
    boolean sound, crono;
    ArrayList<FirebasePuntuacion> puntuaciones, puntuacionPersonal;
    String userName;
    SessionManagement sessionManagement;
    ArrayList<String> seasonsGlobal;

    ArrayAdapter<String> adapterSeason, adapterSeasonSeleccion, adapterStat, adapterTipoCompeticion;
    ArrayAdapter<ClubesInternacional> adapterCompeticionesClubInternacional;
    ArrayAdapter<LigaEuropea> adapterCompeticionesLigaEuropeaArrayAdapter;
    ArrayAdapter<SeleccionesInternacional> adapterCompeticionesSelecciones;

    int version; //version de nuestra app
    FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_menu, container, false);


        initComponents(view);
        res = getResources();
        firebaseMethods = new FirebaseMethods(this);
        comprobacionUltimaVersion();
        return view;
    }

    public static FragmentoMenu newInstance(Bundle datos) {
        if (fragmentoMenu == null) {
            fragmentoMenu =
                    new FragmentoMenu();
        }

        if (datos != null) {
            fragmentoMenu.setArguments(datos);
        }
        return fragmentoMenu;
    }

    public ArrayList<String> getSeasonsGlobal() {
        return seasonsGlobal;
    }

    public void setSeasonsGlobal(ArrayList<String> seasonsGlobal) {
        this.seasonsGlobal = seasonsGlobal;
    }

    private void initComponents(View view) {

        //Al comenzar chequeamos el sonido de la sesion

//        ivSound = view.findViewById(R.id.ivSound);
        ivImagenPrincipal = view.findViewById(R.id.imageViewPrincipal);
        sessionManagement = new SessionManagement(getContext());
        sound = sessionManagement.getSound();
        crono = sessionManagement.getCrono();

        seasonsGlobal = new ArrayList<>();

        adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.TEMPORADAS));
        adapterSeason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterSeasonSeleccion = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.TEMPORADAS_SELECCION));
        adapterSeasonSeleccion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterStat = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.ESTADISTICAS));
        adapterStat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterTipoCompeticion = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.COMPETICIONES));
        adapterTipoCompeticion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterCompeticionesLigaEuropeaArrayAdapter = new ArrayAdapter<LigaEuropea>(getContext(), R.layout.list_spinner, LigaEuropea.values());
        adapterCompeticionesLigaEuropeaArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterCompeticionesClubInternacional = new ArrayAdapter<ClubesInternacional>(getContext(), R.layout.list_spinner, ClubesInternacional.values());
        adapterCompeticionesClubInternacional.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterCompeticionesSelecciones = new ArrayAdapter<SeleccionesInternacional>(getContext(), R.layout.list_spinner, SeleccionesInternacional.values());
        adapterCompeticionesSelecciones.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        btComenzar = view.findViewById(R.id.btnStart);
        btComenzar.setOnClickListener(this);
        btPuntuaciones = view.findViewById(R.id.btnRecords);
        btPuntuaciones.setOnClickListener(this);
        spinnerStats = view.findViewById(R.id.spinnerStats);
        spinnerLiga = view.findViewById(R.id.spinnerLiga);
        spinnerTemporada = view.findViewById(R.id.spinnerTemporada);
        spinnerTemporada.setAdapter(adapterSeason);
        spinnerStats.setAdapter(adapterStat);
        spinnerTipoCompeticion = view.findViewById(R.id.spinnerTipoCompeticion);
        spinnerTipoCompeticion.setAdapter(adapterTipoCompeticion);


        spinnerTemporada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerLiga.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cambiarImagenPrincipal();
                Competicion competicionSeleccionada = (Competicion) spinnerLiga.getSelectedItem();
                if (competicionSeleccionada.getId() != 0) {
                    spinnerTemporada.setEnabled(true);
                    getSeasonsFromFb(competicionSeleccionada.getId());
//                    ArrayList<String> seasons = getSeasonsGlobal();
//                    adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, seasons);
//                    adapterSeason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//                    spinnerTemporada.setAdapter(adapterSeason);

                } else {
                    adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.TEMPORADAS_SELECCION));
                    adapterSeason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerTemporada.setEnabled(false);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTipoCompeticion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    spinnerLiga.setAdapter(adapterCompeticionesLigaEuropeaArrayAdapter);
                    spinnerTemporada.setAdapter(adapterSeason);
                    spinnerTemporada.setEnabled(true);
                    spinnerTemporada.setSelection(0);
                }
                if (i == 1) {
                    spinnerLiga.setAdapter(adapterCompeticionesClubInternacional);
                    spinnerTemporada.setAdapter(adapterSeason);
                    spinnerTemporada.setEnabled(true);
                    //spinnerTemporada.setSelection(getResources().getStringArray(R.array.TEMPORADAS).length - 1);
                }

                if (i == 2) {
                    spinnerLiga.setAdapter(adapterCompeticionesSelecciones);
                    spinnerTemporada.setAdapter(adapterSeasonSeleccion);
                    spinnerTemporada.setEnabled(true);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        params = new Bundle();
    }

    private void cambiarImagenPrincipal() {
        String url = ((Competicion) spinnerLiga.getSelectedItem()).getUrlImage();
        Glide.with(this).load(url).transition(DrawableTransitionOptions.withCrossFade()).override(1024, 1113).into(ivImagenPrincipal);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                //al pulsar el boton de inicio de partida guardamos sonido de la sesion
//                sessionManagement.saveSession(sound, "sound");
                checkSession();
                break;
            case R.id.btnRecords:
                FirebaseAuth mAuth;
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                if (firebaseUser != null) {
                    params.putString("uid", mAuth.getUid());
                }
                Competicion competicion = (Competicion) spinnerLiga.getSelectedItem();
                params.putString("stat", String.valueOf(spinnerStats.getSelectedItem()));
                params.putInt("statId", getStatId());
                //params.putString("liga", String.valueOf(spinnerLiga.getSelectedItem()));
                params.putString("ligaPuntuacion", competicion.getName());
                params.putInt("tipo", competicion.getTipo());
                params.putInt("country", competicion.getCountry());
                params.putString("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                params.putBoolean("sound", sound);//NUEVO
                params.putBoolean("crono", crono);

                firebaseMethods.getTopPuntuaciones(params);
                break;
        }
    }

    private void checkSession() {


        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        sound = sessionManagement.getSound();
        crono = sessionManagement.getCrono();
        String h = "";


        if (firebaseUser != null) {

            if (!crono) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.temporizador_off);
                builder.setMessage(R.string.aviso_temporizador);
                builder.setPositiveButton(R.string.empezar_partida, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        userName = firebaseUser.getDisplayName();
                        Intent intent = new Intent(getActivity().getBaseContext(), GameActivity.class);
                        intent.putExtra("uid", mAuth.getUid());
                        intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
                        Competicion competicion = (Competicion) spinnerLiga.getSelectedItem();
                        intent.putExtra("liga", competicion.getId());
                        intent.putExtra("ligaPuntuacion", competicion.getName());
                        intent.putExtra("tipo", competicion.getTipo());
                        intent.putExtra("country", competicion.getCountry());
                        intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                        intent.putExtra("sound", sound);
                        intent.putExtra("crono", crono);
                        intent.putExtra("loged", true);


                        getActivity().startActivity(intent);

                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.show();
            } else {
                userName = firebaseUser.getDisplayName();
                Intent intent = new Intent(getActivity().getBaseContext(), GameActivity.class);
                intent.putExtra("uid", mAuth.getUid());
                intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
                Competicion competicion = (Competicion) spinnerLiga.getSelectedItem();
                intent.putExtra("liga", competicion.getId());
                intent.putExtra("ligaPuntuacion", competicion.getName());
                intent.putExtra("tipo", competicion.getTipo());
                intent.putExtra("country", competicion.getCountry());
                intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                intent.putExtra("sound", sound);
                intent.putExtra("crono", crono);
                intent.putExtra("loged", true);


                getActivity().startActivity(intent);
            }


        } else {

            //No logueados

            //le pedimos username y despues guardamos la sesion
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(R.string.registrarse);
            builder.setMessage(R.string.sugerencia_registro);
            builder.setPositiveButton(R.string.empezar_partida, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //userName = input.getText().toString();
                    Intent intent = new Intent(getActivity().getBaseContext(), GameActivity.class);
                    intent.putExtra("loged", false);
                    intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
                    Competicion competicion = (Competicion) spinnerLiga.getSelectedItem();
                    intent.putExtra("liga", competicion.getId());
                    intent.putExtra("ligaPuntuacion", competicion.getName());
                    intent.putExtra("tipo", competicion.getTipo());
                    intent.putExtra("country", competicion.getCountry());
                    intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                    intent.putExtra("sound", sound);
                    intent.putExtra("crono", crono);
                    getActivity().startActivity(intent);

                }
            });
            builder.setNegativeButton(R.string.registrarse, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    goToRegister();

                }
            });

            builder.show();

        }
    }


    public void goToRegister() {
        // puntuaciones.sort();


        FragmentoRegister fragmentoRegister = FragmentoRegister.newInstance(null);


        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragmentoRegister, "findThisFragment")
                .addToBackStack(null)
                .commit();


//        Intent activityPuntuaciones = new Intent(getContext(), PuntuacionesActivity.class);
//        activityPuntuaciones.putExtra("puntuaciones", puntuaciones);
//        startActivity(activityPuntuaciones);

    }

    public void goToPuntuaciones() {
        // puntuaciones.sort();

        //params.putString("userName", getUserName());

        Collections.sort(puntuaciones, Collections.reverseOrder());

        params.putParcelableArrayList("puntuaciones", puntuaciones);

        params.putParcelableArrayList("puntuacionPersonal", puntuacionPersonal);

        FragmentoPuntuaciones fragmentoPuntuaciones = FragmentoPuntuaciones.newInstance(params);


        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragmentoPuntuaciones, "findThisFragment")
                .addToBackStack(null)
                .commit();


    }

    private String getUserName() {
//        int userID = sessionManagement.getSession();
//
//        if (userID != -1) {
//            userName = sessionManagement.getSessionUserName();
//
//        } else {
//            userName = "";
//
//        }
        return userName;
    }

    private int getStatId() {
        int statId = 0;
        if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.goles_anotados))) {
            statId = R.string.goles_anotados;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.asistencias))) {
            statId = R.string.asistencias;
        }
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.pases_completados))) {
//            statId = R.string.pases_completados;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.paradas))) {
//            statId = R.string.paradas;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas_amarillas))) {
//            statId = R.string.tarjetas_amarillas;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas_rojas))) {
//            statId = R.string.tarjetas_rojas;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.penaltis))) {
//            statId = R.string.penaltis;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.goles_falta))) {
//            statId = R.string.goles_falta;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.entradas_exitosas))) {
//            statId = R.string.entradas_exitosas;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.minutos))) {
//            statId = R.string.minutos;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas))) {
//            statId = R.string.tarjetas;
//        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.faltas))) {
//            statId = R.string.faltas;
//        }
        return statId;
    }

    private void comprobacionUltimaVersion() {


        //comprobaciones de version
        PackageInfo packageInfo;

        try {
            packageInfo = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0);
            version = packageInfo.versionCode; //version actual instalada

        } catch (Exception e) {
            e.printStackTrace();
        }

        //configuracion firebase remote config

        remoteConfig.setConfigSettings(new FirebaseRemoteConfigSettings.Builder().setDeveloperModeEnabled(true).build());
        HashMap<String, Object> actualizacion = new HashMap<>();
        actualizacion.put("versioncode", version);
        Task<Void> recogerInfoFbRc = remoteConfig.fetch(0);
        recogerInfoFbRc.addOnSuccessListener((Activity) getContext(), aVoid -> {

            remoteConfig.activateFetched();
            checkVersion(version);

        });

    }

    private void checkVersion(int version) {

        int newerVersion = (int) remoteConfig.getLong("versioncode");
        String urlApp = remoteConfig.getString("web");
        String newerVersionName = remoteConfig.getString("versionname");
//        boolean sorteoActivo =  remoteConfig.getBoolean("sorteoActivo");

        if (newerVersion > version) {
            mostrarDialogVersion(urlApp, newerVersionName);

//            Toast.makeText(getContext(), "Existe una nueva version", Toast.LENGTH_SHORT).show();
        } else {
//            Toast.makeText(getContext(), "NO HAY VERSIONES DISPONIBLES ", Toast.LENGTH_SHORT).show();

        }

    }

    private void mostrarDialogVersion(String urlApp, String versionName) {

        new AlertDialog.Builder(getContext())
                .setTitle("Actualización Disponible")
                .setMessage("¿Quieres Actualizar NBA STATS QUIZ a la versión " + versionName + "?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // si damos a aceptar

                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getActivity().getPackageName())));
                        } catch (ActivityNotFoundException e) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + getActivity().getPackageName())));
                        }

                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void getSeasonsFromFb(int liga) {
        ArrayList<String> fbSeasons = new ArrayList<>();
        String key = "temporadas" + liga;
//        FirebaseRemoteConfig remoteConfig = FirebaseRemoteConfig.getInstance();
//        String seasonsFB = remoteConfig.getString(key);

        final FirebaseRemoteConfig config = FirebaseRemoteConfig.getInstance();
        FirebaseRemoteConfigSettings configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        config.setConfigSettings(configSettings);

        config.fetch(3600).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
//                    Toast.makeText(getContext(), "Successfull", Toast.LENGTH_SHORT).show();
                    config.activateFetched();

                } else {
//                    Toast.makeText(getContext(), "Error", Toast.LENGTH_SHORT).show();

                }
                String seasonsFB = FirebaseRemoteConfig.getInstance().getString(key);// empty string


                ArrayList<String> fetchedSeasons = new ArrayList<>();
                Type listType = new TypeToken<List<String>>() {
                }.getType();
                fetchedSeasons = new Gson().fromJson(seasonsFB, listType);
                setSeasonsGlobal(fetchedSeasons);
                String j = seasonsGlobal.get(0);
                String f = "";
                populateSpinnerSeasons();

            }
        });


    }

    private void populateSpinnerSeasons() {

        ArrayList<String> seasons = getSeasonsGlobal();
        if(seasons.size() > 0){
            adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, seasons);
        }
        else{
            adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.TEMPORADAS));
        }

        adapterSeason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemporada.setAdapter(adapterSeason);

    }

    public ArrayList<FirebasePuntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(ArrayList<FirebasePuntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }

    public ArrayList<FirebasePuntuacion> getPuntuacionPersonal() {
        return puntuacionPersonal;
    }

    public void setPuntuacionPersonal(ArrayList<FirebasePuntuacion> puntuacionPersonal) {
        this.puntuacionPersonal = puntuacionPersonal;
    }
}
