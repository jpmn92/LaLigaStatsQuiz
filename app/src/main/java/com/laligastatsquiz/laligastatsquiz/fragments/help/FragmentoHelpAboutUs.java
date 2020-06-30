package com.laligastatsquiz.laligastatsquiz.fragments.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.laligastatsquiz.laligastatsquiz.R;


public class FragmentoHelpAboutUs extends Fragment {


    private static FragmentoHelpAboutUs fragmentoHelpAboutUs;

    public FragmentoHelpAboutUs() {
        // Required empty public constructor
    }

    public static FragmentoHelpAboutUs newInstance(Bundle datos) {
        if (fragmentoHelpAboutUs == null) {
            fragmentoHelpAboutUs =
                    new FragmentoHelpAboutUs();
        }

        if (datos != null) {
            fragmentoHelpAboutUs.setArguments(datos);
        }
        return fragmentoHelpAboutUs;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_help_about_us, container, false);


        return view;
    }


}
