package com.laligastatsquiz.laligastatsquiz.fragments.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.laligastatsquiz.laligastatsquiz.R;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;


public class FragmentoHelpAboutUsNew extends Fragment {


    private static FragmentoHelpAboutUsNew fragmentoHelpAboutUsNew;

    private Element versionElement;

    public FragmentoHelpAboutUsNew() {
        // Required empty public constructor
    }

    public static FragmentoHelpAboutUsNew newInstance(Bundle datos) {
        if (fragmentoHelpAboutUsNew == null) {
            fragmentoHelpAboutUsNew =
                    new FragmentoHelpAboutUsNew();
        }

        if (datos != null) {
            fragmentoHelpAboutUsNew.setArguments(datos);
        }
        return fragmentoHelpAboutUsNew;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        versionElement = new Element();
        versionElement.setTitle("Version 1.2.3");


    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new AboutPage(getContext())
                .isRTL(false)
                .setImage(R.drawable.logo_bowl)
                .setDescription(getString(R.string.aboutUs_paragraph))
                .addEmail("bowlofricedev@gmail.com", "Envíanos un e-mail")
                .addTwitter("bowlofricedev")
                .addInstagram("bowlofricedev")
                .addPlayStore("com.nbastatsquiz")
                .addWebsite("https://bowlofricedev.jdevcloud.com/")
                .addItem(versionElement)
                .create();
    }


}
