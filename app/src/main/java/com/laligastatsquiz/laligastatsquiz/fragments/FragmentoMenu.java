package com.laligastatsquiz.laligastatsquiz.fragments;


import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoRegister;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.laligastatsquiz.laligastatsquiz.tools.SessionManagement;

import java.util.ArrayList;
import java.util.Collections;

public class FragmentoMenu extends Fragment implements View.OnClickListener {
    private static FragmentoMenu fragmentoMenu;

    Button btComenzar, btPuntuaciones;
    Spinner spinnerStats, spinnerLiga, spinnerTemporada;
    ImageView ivSound;
    Resources res;
    FirebaseMethods firebaseMethods;
    Bundle params;
    boolean sound;
    ArrayList<FirebasePuntuacion> puntuaciones;
    String userName;
    SessionManagement sessionManagement;


    ArrayAdapter<String> stringArrayAdapter1920, stringArrayAdapter_old, adapterSeason, adapterStat;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_menu, container, false);


        initComponents(view);
        res = getResources();
        firebaseMethods = new FirebaseMethods(this);
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


    private void initComponents(View view) {

        //Al comenzar chequeamos el sonido de la sesion

        ivSound = view.findViewById(R.id.ivSound);
        sessionManagement = new SessionManagement(getContext());
        sound = sessionManagement.getSound();

        stringArrayAdapter1920 = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.LIGAS));
        stringArrayAdapter1920.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stringArrayAdapter_old = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.LIGAS_OLD));
        stringArrayAdapter_old.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterSeason = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.TEMPORADAS));
        adapterSeason.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterStat = new ArrayAdapter<String>(getContext(), R.layout.list_spinner, getResources().getStringArray(R.array.ESTADISTICAS));
        adapterStat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);



        //dependiendo de si es true pintamos una imagen u otra

        if (sound) {
            ivSound.setImageResource(R.drawable.volume_on);

        } else {
            ivSound.setImageResource(R.drawable.volume_off);

        }


        btComenzar = view.findViewById(R.id.btnStart);
        btComenzar.setOnClickListener(this);
        btPuntuaciones = view.findViewById(R.id.btnRecords);
        btPuntuaciones.setOnClickListener(this);
        spinnerStats = view.findViewById(R.id.spinnerStats);
        spinnerLiga = view.findViewById(R.id.spinnerLiga);
        spinnerTemporada = view.findViewById(R.id.spinnerTemporada);
        spinnerTemporada.setAdapter(adapterSeason);
        spinnerStats.setAdapter(adapterStat);

        spinnerTemporada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
//                    spinnerLiga.setEnabled(true);
                    spinnerLiga.setAdapter(stringArrayAdapter1920);


                } else {
//                    spinnerLiga.setSelection(0);
//                    spinnerLiga.setEnabled(false);
                    spinnerLiga.setAdapter(stringArrayAdapter_old);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ivSound.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (sound) {
                    sound = false;
                    ivSound.setImageResource(R.drawable.volume_off);
                } else {
                    sound = true;
                    ivSound.setImageResource(R.drawable.volume_on);
                }
            }
        });
        params = new Bundle();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                //al pulsar el boton de inicio de partida guardamos sonido de la sesion
                sessionManagement.saveSession(sound);
                checkSession();
                break;
            case R.id.btnRecords:
                FirebaseAuth mAuth;
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                if (firebaseUser != null) {
                    params.putString("uid", mAuth.getUid());
                }
                params.putString("stat", String.valueOf(spinnerStats.getSelectedItem()));
                params.putInt("statId", getStatId());
                params.putString("liga", String.valueOf(spinnerLiga.getSelectedItem()));
                params.putString("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                firebaseMethods.getTopPuntuaciones(params);
                break;
        }
    }

    private void checkSession() {


        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();


        if (firebaseUser != null) {
            userName = firebaseUser.getDisplayName();
            Intent intent = new Intent(getActivity().getBaseContext(), GameActivity.class);
            intent.putExtra("uid", mAuth.getUid());
            intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
            intent.putExtra("liga", String.valueOf(spinnerLiga.getSelectedItem()));
            intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
            intent.putExtra("sound", sound);
            intent.putExtra("loged", true);


            getActivity().startActivity(intent);
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
                    intent.putExtra("liga", String.valueOf(spinnerLiga.getSelectedItem()));
                    intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                    intent.putExtra("sound", sound);
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
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.pases_completados))) {
            statId = R.string.pases_completados;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.paradas))) {
            statId = R.string.paradas;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas_amarillas))) {
            statId = R.string.tarjetas_amarillas;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas_rojas))) {
            statId = R.string.tarjetas_rojas;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.penaltis))) {
            statId = R.string.penaltis;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.goles_falta))) {
            statId = R.string.goles_falta;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.entradas_exitosas))) {
            statId = R.string.entradas_exitosas;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.minutos))) {
            statId = R.string.minutos;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.tarjetas))) {
            statId = R.string.tarjetas;
        } else if (String.valueOf(spinnerStats.getSelectedItem()).equalsIgnoreCase(getString(R.string.faltas))) {
            statId = R.string.faltas;
        }
        return statId;
    }


    public ArrayList<FirebasePuntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(ArrayList<FirebasePuntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
}
