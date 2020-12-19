package com.laligastatsquiz.laligastatsquiz.fragments;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.laligastatsquiz.laligastatsquiz.NavigationDrawerActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPhoto;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPhotoSize;
import com.laligastatsquiz.laligastatsquiz.tools.Constantes;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.laligastatsquiz.laligastatsquiz.tools.GenerateImageUrl;
import com.laligastatsquiz.laligastatsquiz.tools.SelectorImagenActivity;
import com.laligastatsquiz.laligastatsquiz.tools.SessionManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentoAccount extends Fragment {

    Button btnSetOptions;
    TextView txtUserName, txtCambiaAvatar;
    SessionManagement sm;
    GenerateImageUrl generateImageUrl;
    ImageView ivAvatar;
    CircleImageView circleImageView;
    NavigationDrawerActivity navigationDrawerActivity;
    String urlCode;
    ArrayList<FootballPlayer> footballPlayers;
    FirebaseMethods firebaseMethods;
    boolean codigo;
    TextView txtCodigo;
    private String urlFromDialog;
    FirebaseUser currentFirebaseUser;

    private static FragmentoAccount fragmentoAccount;

    private AdView adViewProfile;

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


        currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_account, container, false);

        sm = new SessionManagement(getContext());
        generateImageUrl = new GenerateImageUrl();
        if(Constantes.DEVELOPER_MODE){

            inicializarPublicidad(view);
        }

        initComponents(view);

        firebaseMethods = new FirebaseMethods(this);

//        txtUserName.setText(sm.getSessionUserName());

        if(currentFirebaseUser != null){
            txtUserName.setText(currentFirebaseUser.getDisplayName());
            Glide.with(getContext()).load(currentFirebaseUser.getPhotoUrl()).into(circleImageView);

        }

//TODO: no permitimos cambiar el username de momento
        txtUserName.setEnabled(true);


        footballPlayers = generateImageUrl.getFootballPlayers();

        //ordenamos array
        if (footballPlayers.size() > 0) {
            Collections.sort(footballPlayers, new Comparator<FootballPlayer>() {
                @Override
                public int compare(FootballPlayer o1, FootballPlayer o2) {
                    return o1.getNickname().compareTo(o2.getNickname());
                }
            });
        }

        btnSetOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkInternetConnection() == true) {

                    //cogemos jugador seleccionado y pasamos la url de su imagen

                    String userName = txtUserName.getText().toString();
                    String email = sm.getSessionEmail();

                    if(codigo){
                        sm.saveSession(userName, email, urlCode);

                        firebaseMethods.updateUser(userName, urlCode,getContext());
                    }
                    else{

                        if(urlFromDialog != null && !"".equalsIgnoreCase(urlFromDialog)){
                            sm.saveSession(userName, email, urlFromDialog);
                            firebaseMethods.updateUser(userName, urlFromDialog,getContext());
                        }

                        else if (sm.getSesionImage() != "") {

                            for (int i = 0; i < footballPlayers.size(); i++) {

                                if (footballPlayers.get(i).getPhotos().getPhoto().getBig().equalsIgnoreCase(sm.getSesionImage())) {
                                    sm.saveSession(userName, email, footballPlayers.get(i).getPhotos().getPhoto().getBig());
                                    firebaseMethods.updateUser(userName, footballPlayers.get(i).getPhotos().getPhoto().getBig(),getContext());
                                }

                            }

                        }
                    }



//                    Toast.makeText(getContext(), R.string.config_updated, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), R.string.sin_conexion, Toast.LENGTH_SHORT).show();

                }


            }
        });


        txtCambiaAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialog = new SelectorImagenActivity(fragmentoAccount);
                dialog.show(getFragmentManager(), "NoticeDialogFragment");
            }
        });

        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FragmentoSelectorImagen fragmentoSelectorImagen = FragmentoSelectorImagen.newInstance(null);
//
//
//                getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.main_content, fragmentoSelectorImagen, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();

                DialogFragment dialog = new SelectorImagenActivity(fragmentoAccount);
                dialog.show(getFragmentManager(), "NoticeDialogFragment");
            }
        });

        txtCodigo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                firebaseMethods.readCode(s.toString(), fragmentoAccount);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        return view;
    }

    private void inicializarPublicidad( View view) {
        MobileAds.initialize(getContext());
        adViewProfile = view.findViewById(R.id.adViewProfile);
        AdRequest adRequest = new AdRequest.Builder().build();
        System.out.println(adViewProfile.getAdUnitId());
        adViewProfile.loadAd(adRequest);
        adViewProfile.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                adViewProfile.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    private void initComponents(View view) {

        btnSetOptions = view.findViewById(R.id.btnSetOptions);
        txtUserName = view.findViewById(R.id.txtUserNameOptions);
        txtCodigo = view.findViewById(R.id.txtCode);
//        ivAvatar = view.findViewById(R.id.ivAvatar);
        circleImageView = view.findViewById(R.id.ivAvatar);
        txtCambiaAvatar = view.findViewById(R.id.txtCambiaAvatar);
//        Glide.with(getContext()).load(sm.getSesionImage()).into(circleImageView);

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

    public void urlCode(String url){
        if(!url.equalsIgnoreCase(footballPlayers.get(footballPlayers.size() - 1).getPhotos().getPhoto().getBig())){
            FootballPlayer newFootballPlayer = generatePlayer(txtCodigo.getText().toString().toUpperCase(), url);
            footballPlayers.add(newFootballPlayer);
            ArrayAdapter<FootballPlayer> adapter = new ArrayAdapter<FootballPlayer>(getContext(), R.layout.support_simple_spinner_dropdown_item, footballPlayers);
            Glide.with(getContext()).load(url).into(circleImageView);
            urlCode = url;
            codigo = true;
        }

    }

    private FootballPlayer generatePlayer(String nickname, String image) {
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.setNickname(nickname);
        footballPlayer.setPhotos(new FootballPhoto());
        footballPlayer.getPhotos().setPhoto(new FootballPhotoSize());
        footballPlayer.getPhotos().getPhoto().setBig(image);
        return footballPlayer;
    }

    public String getUrlFromDialog() {
        return urlFromDialog;
    }

    public void setUrlFromDialog(String urlFromDialog) {
        this.urlFromDialog = urlFromDialog;
    }

    public static FragmentoAccount getFragmentoAccount() {
        return fragmentoAccount;
    }

    public static void setFragmentoAccount(FragmentoAccount fragmentoAccount) {
        FragmentoAccount.fragmentoAccount = fragmentoAccount;
    }

    public CircleImageView getCircleImageView() {
        return circleImageView;
    }

    public void setCircleImageView(CircleImageView circleImageView) {
        this.circleImageView = circleImageView;
    }

    public ArrayList<FootballPlayer> getFootballPlayers() {
        return footballPlayers;
    }

    public void setFootballPlayers(ArrayList<FootballPlayer> footballPlayers) {
        this.footballPlayers = footballPlayers;
    }
}