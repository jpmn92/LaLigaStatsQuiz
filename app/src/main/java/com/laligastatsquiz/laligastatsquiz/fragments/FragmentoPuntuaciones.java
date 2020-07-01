package com.laligastatsquiz.laligastatsquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.adaptador.AdapterPuntuaciones;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;

import java.util.ArrayList;


public class FragmentoPuntuaciones extends Fragment {

    private RecyclerView myrv, rvPuntuacionPersonal;
    private RecyclerView.Adapter adapter, adapterPersonal;
    private RecyclerView.LayoutManager lManager, lManagerPersonal;
    private ArrayList<FirebasePuntuacion> listadoPuntuaciones, listadoPuntuacionesTop50, listadoRecordPersonal; // listadoRecordPersonal es de un único elemento
    TextView txtPuntuacion;
    String tipoTemporada;
    String draftTeam, draftCollege, draftSeason, liga;

    private static FragmentoPuntuaciones fragmentoPuntuaciones;
    Bundle bundle;


    public FragmentoPuntuaciones() {
        // Required empty public constructor
    }


    public static FragmentoPuntuaciones newInstance(Bundle datos) {
        if (fragmentoPuntuaciones == null) {
            fragmentoPuntuaciones =
                    new FragmentoPuntuaciones();
        }

        if (datos != null) {
            fragmentoPuntuaciones.setArguments(datos);
        }
        return fragmentoPuntuaciones;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fragmento_puntuaciones, container, false);


        bundle = fragmentoPuntuaciones.getArguments();
        tipoTemporada = "";
//        listadoPuntuaciones = new ArrayList<>();
        listadoPuntuaciones = bundle.getParcelableArrayList("puntuaciones");
        // listadoRecordPersonal = bundle.getParcelableArrayList("puntuaciones");

        rvPuntuacionPersonal = view.findViewById(R.id.recycler_view_puntuacion_personal);
        myrv = view.findViewById(R.id.recycler_view_puntuaciones);
        txtPuntuacion = view.findViewById(R.id.txtPuntuaciones);


        if (listadoPuntuaciones.size() > 0) {
            txtPuntuacion.setText(listadoPuntuaciones.get(0).getLiga()+" | "+getString(Integer.parseInt(listadoPuntuaciones.get(0).getStatCategory())) + " | " + listadoPuntuaciones.get(0).getSeason());

        } else {
            txtPuntuacion.setText(R.string.no_puntuaciones);
        }

        getTop50();
        //ordenamos listado puntuaciones
        adapter = new AdapterPuntuaciones(listadoPuntuacionesTop50);
        lManager = new LinearLayoutManager(getContext());
        lManagerPersonal = new LinearLayoutManager(getContext());

        buscarRecordPersonal();

        adapterPersonal = new AdapterPuntuaciones(listadoRecordPersonal);
        rvPuntuacionPersonal.setLayoutManager(lManagerPersonal);
        rvPuntuacionPersonal.setAdapter(adapterPersonal);
        //rvPuntuacionPersonal.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        myrv.setLayoutManager(lManager);
        myrv.setAdapter(adapter);
        myrv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        return view;
    }

    private void getTop50() {
        listadoPuntuacionesTop50 = new ArrayList<FirebasePuntuacion>();
        FirebasePuntuacion puntuacionActualTop;
        if (listadoPuntuaciones.size() < 49) {


//            for(FirebasePuntuacion firebasePuntuacion: listadoPuntuaciones){
//                listadoPuntuacionesTop50.add(firebasePuntuacion);
//            }

            for (int i = 0; i < listadoPuntuaciones.size(); i++) {

                puntuacionActualTop = listadoPuntuaciones.get(i);
                puntuacionActualTop.setRanking(i + 1);
                listadoPuntuacionesTop50.add(puntuacionActualTop);

            }


        } else {
            for (int i = 0; i <= 49; i++) {
                puntuacionActualTop = listadoPuntuaciones.get(i);
                puntuacionActualTop.setRanking(i + 1);
                listadoPuntuacionesTop50.add(puntuacionActualTop);
            }
        }

    }

    private void buscarRecordPersonal() {
        listadoRecordPersonal = new ArrayList<FirebasePuntuacion>();
        FirebaseAuth mAuth;
        FirebasePuntuacion puntuacionActual;
        mAuth = FirebaseAuth.getInstance();
        String myUid = mAuth.getUid();
        if (mAuth.getUid() != null) {
            String uid = mAuth.getUid();
            if (listadoPuntuaciones.size() > 0) {


                for (int i = 0; i < listadoPuntuaciones.size(); i++) {

                    puntuacionActual = listadoPuntuaciones.get(i);
                    puntuacionActual.setRanking(i + 1);

                    if (puntuacionActual.getUid().equals(uid)) {
                        listadoRecordPersonal.add(puntuacionActual);
                    }

                }

//                for(FirebasePuntuacion firebasePuntuacion: listadoPuntuaciones){
//                    if(firebasePuntuacion.getUid().equals(uid)){
//                        listadoRecordPersonal.add(firebasePuntuacion);
//                    }
//                }

                if (listadoRecordPersonal.size() > 0) {
                    FirebasePuntuacion record = listadoRecordPersonal.get(0);
                    listadoRecordPersonal = new ArrayList<FirebasePuntuacion>();
                    listadoRecordPersonal.add(record);
                } else {
                    String h = "No hay puntuaciones";
                }
            }
        }
    }
}