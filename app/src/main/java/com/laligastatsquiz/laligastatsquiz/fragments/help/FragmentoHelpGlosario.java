package com.laligastatsquiz.laligastatsquiz.fragments.help;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.laligastatsquiz.laligastatsquiz.R;


public class FragmentoHelpGlosario extends Fragment {


    private static FragmentoHelpGlosario fragmentoHelpGlosario;

    private TextView pts, reb, dreb, oreb, ast, stl, blk, tov, min, fg3pct, fg3m, ftpct, ftm;

    public FragmentoHelpGlosario() {
        // Required empty public constructor
    }

    public static FragmentoHelpGlosario newInstance(Bundle datos) {
        if (fragmentoHelpGlosario == null) {
            fragmentoHelpGlosario =
                    new FragmentoHelpGlosario();
        }

        if (datos != null) {
            fragmentoHelpGlosario.setArguments(datos);
        }
        return fragmentoHelpGlosario;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_help_glosario, container, false);


        initComponents(view);



        return view;
    }

    private void initComponents(View view) {

    }


}
