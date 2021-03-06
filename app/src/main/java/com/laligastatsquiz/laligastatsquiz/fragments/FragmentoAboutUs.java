package com.laligastatsquiz.laligastatsquiz.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.laligastatsquiz.laligastatsquiz.R;


public class FragmentoAboutUs extends Fragment {


    private static FragmentoAboutUs fragmentoAboutUs;

    public FragmentoAboutUs() {
        // Required empty public constructor
    }

    public static FragmentoAboutUs newInstance(Bundle datos) {
        if (fragmentoAboutUs == null) {
            fragmentoAboutUs =
                    new FragmentoAboutUs();
        }

        if (datos != null) {
            fragmentoAboutUs.setArguments(datos);
        }
        return fragmentoAboutUs;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_about_us, container, false);
        return view;
    }
}
