package com.laligastatsquiz.laligastatsquiz.fragments;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.laligastatsquiz.laligastatsquiz.NavigationDrawerActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.laligastatsquiz.laligastatsquiz.tools.GenerateImageUrl;
import com.laligastatsquiz.laligastatsquiz.tools.SessionManagement;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentoAccount extends Fragment {

    Button btnSetOptions;
    TextView txtUserName;
    SessionManagement sm;
    Spinner spinnerProfile;
    GenerateImageUrl generateImageUrl;
    ImageView ivAvatar;
    CircleImageView circleImageView;
    NavigationDrawerActivity navigationDrawerActivity;
    FirebaseMethods firebaseMethods;

    private static FragmentoAccount fragmentoAccount;

    public FragmentoAccount() {
        // Required empty public constructor
    }

    public static FragmentoAccount newInstance(Bundle datos) {
        if (fragmentoAccount == null) {
            fragmentoAccount =
                    new FragmentoAccount();
        }

        if (datos != null) {
            fragmentoAccount.setArguments(datos);
        }
        return fragmentoAccount;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_account, container, false);

        sm = new SessionManagement(getContext());
        generateImageUrl = new GenerateImageUrl();

        initComponents(view);

        firebaseMethods = new FirebaseMethods(this);

        txtUserName.setText(sm.getSessionUserName());
//TODO: no permitimos cambiar el username de momento
        txtUserName.setEnabled(false);


        ArrayList<LaLigaPlayer> laLigaPlayers = generateImageUrl.getLaLigaPlayers();

        //ordenamos array
        if (laLigaPlayers.size() > 0) {
            Collections.sort(laLigaPlayers, new Comparator<LaLigaPlayer>() {
                @Override
                public int compare(LaLigaPlayer o1, LaLigaPlayer o2) {
                    return o1.getNickname().compareTo(o2.getNickname());
                }
            });
        }

        ArrayAdapter<LaLigaPlayer> adapter = new ArrayAdapter<LaLigaPlayer>(getContext(), R.layout.support_simple_spinner_dropdown_item, laLigaPlayers);
        spinnerProfile.setAdapter(adapter);

        //si el perfil tiene imagen, que busque de quien es esa imagen y la ponga como valor por defecto del spinner
        if (sm.getSesionImage() != "") {

            for (int i = 0; i < laLigaPlayers.size(); i++) {

                if (laLigaPlayers.get(i).getPhotos().getPhoto().getBig().equalsIgnoreCase(sm.getSesionImage())) {
                    spinnerProfile.setSelection(i);
                }

            }


        }


        btnSetOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkInternetConnection() == true) {

                    //cogemos jugador seleccionado y pasamos la url de su imagen
                    LaLigaPlayer laLigaPlayer = (LaLigaPlayer) spinnerProfile.getSelectedItem();

                    String userName = txtUserName.getText().toString();
                    String email = sm.getSessionEmail();

                    sm.saveSession(txtUserName.getText().toString(), email, laLigaPlayer.getPhotos().getPhoto().getBig());

                    firebaseMethods.updateAvatar(laLigaPlayer.getPhotos().getPhoto().getBig(),getContext());



//                    Toast.makeText(getContext(), R.string.config_updated, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), R.string.sin_conexion, Toast.LENGTH_SHORT).show();

                }


            }
        });

        spinnerProfile.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LaLigaPlayer laLigaPlayer = (LaLigaPlayer) spinnerProfile.getSelectedItem();
                Picasso.with(getContext()).load(laLigaPlayer.getPhotos().getPhoto().getBig()).into(circleImageView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;
    }


    private void initComponents(View view) {

        btnSetOptions = view.findViewById(R.id.btnSetOptions);
        txtUserName = view.findViewById(R.id.txtUserNameOptions);
        spinnerProfile = view.findViewById(R.id.spinnerProfilePicture);
//        ivAvatar = view.findViewById(R.id.ivAvatar);
        circleImageView = view.findViewById(R.id.ivAvatar);
        Picasso.with(getContext()).load(sm.getSesionImage()).into(circleImageView);

    }

    private Boolean checkInternetConnection() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(getActivity().CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;


        } else {
            connected = false;
//            Toast.makeText(getContext(), "no hay conexion a internet", Toast.LENGTH_SHORT).show();
        }

        return connected;

    }
}