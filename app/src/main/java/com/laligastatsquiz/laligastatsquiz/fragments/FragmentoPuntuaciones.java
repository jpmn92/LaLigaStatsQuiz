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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.adaptador.AdapterPuntuaciones;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.tools.Constantes;

import java.util.ArrayList;


public class FragmentoPuntuaciones extends Fragment {

    private RecyclerView myrv, rvPuntuacionPersonal;
    private RecyclerView.Adapter adapter, adapterPersonal;
    private RecyclerView.LayoutManager lManager, lManagerPersonal;
    private ArrayList<FirebasePuntuacion> listadoPuntuaciones, listadoPuntuacionesTop50, puntuacionPersonal; // listadoRecordPersonal es de un único elemento
    TextView txtPuntuacion;
    String tipoTemporada;
    private AdView mAdView;

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

        if(!Constantes.DEVELOPER_MODE){
            inicializarPublicidad(view);
        }

        bundle = fragmentoPuntuaciones.getArguments();
        tipoTemporada = "";
        listadoPuntuaciones = bundle.getParcelableArrayList("puntuaciones");
        puntuacionPersonal = bundle.getParcelableArrayList("puntuacionPersonal");

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

        adapterPersonal = new AdapterPuntuaciones(puntuacionPersonal);
        rvPuntuacionPersonal.setLayoutManager(lManagerPersonal);
        rvPuntuacionPersonal.setAdapter(adapterPersonal);

        myrv.setLayoutManager(lManager);
        myrv.setAdapter(adapter);
        myrv.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));

        return view;
    }

    private void inicializarPublicidad( View view) {
        MobileAds.initialize(getContext());
        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                System.out.println("PUBLI CERRADA");
                mAdView.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    private void getTop50() {
        listadoPuntuacionesTop50 = new ArrayList<FirebasePuntuacion>();
        FirebasePuntuacion puntuacionActualTop;

        for (int i = 0; i < listadoPuntuaciones.size(); i++) {
            puntuacionActualTop = listadoPuntuaciones.get(i);
            puntuacionActualTop.setRanking(i + 1);
            listadoPuntuacionesTop50.add(puntuacionActualTop);
        }

    }
}