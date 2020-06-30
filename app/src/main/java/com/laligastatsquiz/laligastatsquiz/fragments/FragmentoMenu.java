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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoRegister;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;

import java.util.ArrayList;
import java.util.Collections;

public class FragmentoMenu extends Fragment implements View.OnClickListener {
    private static FragmentoMenu fragmentoMenu;

    Button btComenzar, btPuntuaciones;
    Spinner spinnerStats, spinnerLiga, spinnerTemporada;
    ImageView ivSound;
    Resources res;
    FirebaseMethods firebaseMethods;
    boolean sound;
    ArrayList<FirebasePuntuacion> puntuaciones;
    String userName;

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
        btComenzar = view.findViewById(R.id.btnStart);
        btComenzar.setOnClickListener(this);
        btPuntuaciones = view.findViewById(R.id.btnRecords);
        spinnerStats = view.findViewById(R.id.spinnerStats);
        spinnerLiga = view.findViewById(R.id.spinnerLiga);
        spinnerTemporada = view.findViewById(R.id.spinnerTemporada);
        spinnerTemporada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    spinnerLiga.setEnabled(true);
                }
                else{
                    spinnerLiga.setSelection(0);
                    spinnerLiga.setEnabled(false);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ivSound = view.findViewById(R.id.ivSound);
        ivSound.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(sound){
                    sound = false;
                    ivSound.setImageResource(R.drawable.volume_off);
                }
                else{
                    sound = true;
                    ivSound.setImageResource(R.drawable.volume_on);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                Intent intent = new Intent(getActivity().getBaseContext(), GameActivity.class);
                intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
                intent.putExtra("liga", String.valueOf(spinnerLiga.getSelectedItem()));
                intent.putExtra("season", String.valueOf(spinnerTemporada.getSelectedItem()));
                intent.putExtra("sound", sound);
                this.startActivity(intent);
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



    public ArrayList<FirebasePuntuacion> getPuntuaciones() {
        return puntuaciones;
    }

    public void setPuntuaciones(ArrayList<FirebasePuntuacion> puntuaciones) {
        this.puntuaciones = puntuaciones;
    }
}
