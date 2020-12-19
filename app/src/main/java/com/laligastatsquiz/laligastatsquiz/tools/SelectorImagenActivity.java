package com.laligastatsquiz.laligastatsquiz.tools;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.DialogFragment;

import com.bumptech.glide.Glide;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.adaptador.AdapterAvatar;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;
import com.laligastatsquiz.laligastatsquiz.fragments.FragmentoAccount;

public class SelectorImagenActivity extends DialogFragment {


    private static GridView grid;
    private FragmentoAccount fragmentoAccount;

    public SelectorImagenActivity(FragmentoAccount fragmentoAccount){
        this.fragmentoAccount = fragmentoAccount;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = requireActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.selector_imagenes, null);

        builder.setView(view);

        grid = view.findViewById(R.id.grid);

        grid.setAdapter(new AdapterAvatar(this.getContext(), fragmentoAccount.getFootballPlayers()));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                FootballPlayer laLigaPlayer = (FootballPlayer) grid.getAdapter().getItem(position);
                fragmentoAccount.setUrlFromDialog(laLigaPlayer.getPhotos().getPhoto().getBig());
                Glide.with(getContext()).load(laLigaPlayer.getPhotos().getPhoto().getBig()).into(fragmentoAccount.getCircleImageView());
                dismiss();
            }
        });

        return builder.create();
    }
}
