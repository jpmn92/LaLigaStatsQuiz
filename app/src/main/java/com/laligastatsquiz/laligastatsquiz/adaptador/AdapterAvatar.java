package com.laligastatsquiz.laligastatsquiz.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;

import java.util.ArrayList;

/**
 * {@link BaseAdapter} para poblar coches en un grid view
 */

public class AdapterAvatar extends BaseAdapter {
    private Context context;
    private ArrayList<FootballPlayer> laLigaPlayers;

    public AdapterAvatar(Context context, ArrayList<FootballPlayer> laLigaPlayers) {
        this.context = context;
        this.laLigaPlayers = laLigaPlayers;
    }

    @Override
    public int getCount() {
        return laLigaPlayers.size();
    }

    @Override
    public FootballPlayer getItem(int position) {
        return laLigaPlayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item, viewGroup, false);
        }

        ImageView imagenPlayer = (ImageView) view.findViewById(R.id.imagen_player);
        TextView nombrePlayer = (TextView) view.findViewById(R.id.nombre_player);


        final FootballPlayer item = getItem(position);
        Glide.with(context).load(item.getPhotos().getPhoto().getBig()).into(imagenPlayer);
        nombrePlayer.setText(item.getNickname());

        return view;
    }

}