package com.laligastatsquiz.laligastatsquiz.tools;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.adaptador.AdapterAvatar;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;
import com.laligastatsquiz.laligastatsquiz.fragments.FragmentoAccount;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoRegister;

import java.util.ArrayList;

public class SelectorImagenActivity extends DialogFragment {


    private static GridView grid;
    private FragmentoAccount fragmentoAccount;
    private FragmentoRegister fragmentoRegister;
    private EditText txtSearchAvatar;
    private ArrayList<FootballPlayer> laLigaPlayers;
    private ArrayList<FootballPlayer> avatares;

    public SelectorImagenActivity(FragmentoAccount fragmentoAccount){
        this.fragmentoAccount = fragmentoAccount;
        this.fragmentoRegister = null;
    }

    public SelectorImagenActivity(FragmentoRegister fragmentoRegister){
        this.fragmentoRegister = fragmentoRegister;
        this.fragmentoAccount = null;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.selector_imagenes, null);

        builder.setView(view);

        laLigaPlayers = new ArrayList<>();
        avatares = new ArrayList<>();
        grid = view.findViewById(R.id.grid);

        if(fragmentoAccount != null){
            laLigaPlayers.addAll(fragmentoAccount.getFootballPlayers());
            avatares.addAll(fragmentoAccount.getFootballPlayers());
        }
        else if (fragmentoRegister != null){
            laLigaPlayers.addAll(fragmentoRegister.getLaLigaPlayers());
            avatares.addAll(fragmentoRegister.getLaLigaPlayers());
        }

        txtSearchAvatar = view.findViewById(R.id.txtSearchAvatar);

        txtSearchAvatar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                avatares = searchAvatar(s.toString());
                loadAvatars();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        loadAvatars();

        return builder.create();
    }

    private void loadAvatars() {
        if(fragmentoAccount != null){
            grid.setAdapter(new AdapterAvatar(this.getContext(), avatares));

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    FootballPlayer laLigaPlayer = (FootballPlayer) grid.getAdapter().getItem(position);
                    fragmentoAccount.setUrlFromDialog(laLigaPlayer.getPhotos().getPhoto().getBig());
                    Glide.with(getContext()).load(laLigaPlayer.getPhotos().getPhoto().getBig()).into(fragmentoAccount.getCircleImageView());
                    dismiss();
                }
            });
        }

        if(fragmentoRegister != null){
            grid.setAdapter(new AdapterAvatar(this.getContext(), avatares));

            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    FootballPlayer laLigaPlayer = (FootballPlayer) grid.getAdapter().getItem(position);
                    fragmentoRegister.setLaLigaPlayer(laLigaPlayer);
                    Glide.with(getContext()).load(laLigaPlayer.getPhotos().getPhoto().getBig()).into(fragmentoRegister.getCircleImageView());
                    dismiss();
                }
            });
        }
    }

    private ArrayList<FootballPlayer> searchAvatar(String search) {
        ArrayList<FootballPlayer> laLigaPlayersAux = new ArrayList<>();
        if(!search.equalsIgnoreCase("") && search != null){
            //laLigaPlayersAux.addAll(laLigaPlayers);
            laLigaPlayersAux.clear();
            for(FootballPlayer laLigaPlayer: laLigaPlayers){

                if(laLigaPlayer.getNickname().toUpperCase().contains(search.toUpperCase())){
                    laLigaPlayersAux.add(laLigaPlayer);
                }
            }
        }
        else{
            if(fragmentoAccount != null){
                laLigaPlayersAux.addAll(fragmentoAccount.getFootballPlayers());
            }
            else if (fragmentoRegister != null){
                laLigaPlayersAux.addAll(fragmentoRegister.getLaLigaPlayers());
            }
        }

        return laLigaPlayersAux;
    }
}
