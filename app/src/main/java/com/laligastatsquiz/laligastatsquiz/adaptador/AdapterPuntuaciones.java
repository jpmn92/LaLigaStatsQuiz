package com.laligastatsquiz.laligastatsquiz.adaptador;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.tools.GenerateImageUrl;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPuntuaciones extends RecyclerView.Adapter<AdapterPuntuaciones.PuntuacionesViewHolder> {

    private ArrayList<FirebasePuntuacion> listadoPuntuaciones;


    public class PuntuacionesViewHolder extends RecyclerView.ViewHolder {

        public TextView puntos, fecha, username, posicion;
        public CircleImageView circleImageView;


        public PuntuacionesViewHolder(@NonNull View v) {
            super(v);


            circleImageView = (CircleImageView) v.findViewById(R.id.avatar);
            fecha = (TextView) v.findViewById(R.id.puntuaciones_fecha);
            puntos = (TextView) v.findViewById(R.id.puntuaciones_puntos);
            username = (TextView) v.findViewById(R.id.puntuaciones_username);
            posicion = (TextView) v.findViewById(R.id.posicionPuntuacion);


        }
    }

    public AdapterPuntuaciones(ArrayList<FirebasePuntuacion> puntuaciones) {

        this.listadoPuntuaciones = puntuaciones;

    }

    @Override
    public PuntuacionesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,
                        viewGroup, false);


        return new PuntuacionesViewHolder(v);
    }


    @Override
    public void onBindViewHolder(PuntuacionesViewHolder viewHolder, final int i) {


        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        String myUid = mAuth.getUid();

        GenerateImageUrl generateImageUrl = new GenerateImageUrl();
        FirebasePuntuacion firebasePuntuacion = listadoPuntuaciones.get(i);

//        int size = Math.min(viewHolder.circleImageView.getWidth(), viewHolder.circleImageView.getHeight());
//        int x = (viewHolder.circleImageView.getWidth() - size) / 4;
//        int y = (viewHolder.circleImageView.getHeight() - size) / 4;


        if (firebasePuntuacion.getImage() == null || firebasePuntuacion.getImage().equalsIgnoreCase("")) {
            Glide.with(viewHolder.circleImageView.getContext()).load(generateImageUrl.getRandomAvatar()).circleCrop().into(viewHolder.circleImageView);

        } else {
            Glide.with(viewHolder.circleImageView.getContext())

                    .load(firebasePuntuacion.getImage())
//                    .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
//                    .networkPolicy(NetworkPolicy.NO_CACHE, NetworkPolicy.NO_STORE)
                    .circleCrop()
                    .into(viewHolder.circleImageView);

        }

        if(firebasePuntuacion.getUid().equals(myUid)){
            viewHolder.circleImageView.setFillColor(Color.parseColor("#0288D1"));

        }else{
            viewHolder.circleImageView.setFillColor(Color.parseColor("#FF9800"));
        }

        if(firebasePuntuacion.getRanking() == 0){
            viewHolder.posicion.setText("⚽");
        }
        else if(firebasePuntuacion.getRanking() == 1){
            viewHolder.posicion.setText("\uD83E\uDD47");
        }
        else if(firebasePuntuacion.getRanking() == 2){
            viewHolder.posicion.setText("\uD83E\uDD48");
        }
        else if(firebasePuntuacion.getRanking() == 3){
            viewHolder.posicion.setText("\uD83E\uDD49");
        }
        else{
            viewHolder.posicion.setText(Integer.toString(firebasePuntuacion.getRanking()));
        }
        viewHolder.username.setText(firebasePuntuacion.getUsername());
        viewHolder.fecha.setText(firebasePuntuacion.getDate());
        viewHolder.puntos.setText("Pts: " + Integer.toString(firebasePuntuacion.getPoints()));


    }

    @Override
    public int getItemCount() {
        if (listadoPuntuaciones == null) {


            return 0;
        } else {
            return listadoPuntuaciones.size();
        }
    }


}


