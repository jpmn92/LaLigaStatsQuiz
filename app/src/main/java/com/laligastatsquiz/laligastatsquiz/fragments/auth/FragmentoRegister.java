package com.laligastatsquiz.laligastatsquiz.fragments.auth;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;
import com.laligastatsquiz.laligastatsquiz.tools.FirebaseMethods;
import com.laligastatsquiz.laligastatsquiz.tools.GenerateImageUrl;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;


public class FragmentoRegister extends FragmentoAutentificacion {


    private EditText email, passwd, passwd2, username;
    private TextView txtError;
    private Button btnRegister, btnGoogle;
    private FirebaseMethods firebaseMethods;
    private String mensaje;
    private static FragmentoRegister fragmentoRegister;
    private CircleImageView circleImageView;
    private GenerateImageUrl generateImageUrl;
    private Spinner spinner;
    private TextView goToLogin;


    public FragmentoRegister() {
        // Required empty public constructor
    }

    public static FragmentoRegister newInstance(Bundle datos) {
        if (fragmentoRegister == null) {
            fragmentoRegister =
                    new FragmentoRegister();
        }

        if (datos != null) {
            fragmentoRegister.setArguments(datos);
        }
        return fragmentoRegister;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragmento_register, container, false);

        firebaseMethods = new FirebaseMethods(this);
        initComponents(view);

        populateSpinner();

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cogemos jugador seleccionado y pasamos la url de su imagen
                LaLigaPlayer laLigaPlayer = (LaLigaPlayer) spinner.getSelectedItem();

                txtError.setVisibility(View.GONE);
                if (isEmailValid(email.getText().toString())) {
                    if (passwd.getText().toString().equals(passwd2.getText().toString())) {

                        //6 es el minimo de seguridad de firebase
                        if (passwd.getText().toString().length() >= 6) {
                            //registrar

                            final ProgressDialog progressDialog = new ProgressDialog(getContext(), R.style.Theme_AppCompat_DayNight_Dialog);
                            progressDialog.setIndeterminate(true);
                            progressDialog.setMessage("Iniciando...");
                            progressDialog.show();


                            new android.os.Handler().postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            firebaseMethods.registerUser(email.getText().toString(), passwd.getText().toString(), username.getText().toString(), laLigaPlayer.getPhotos().getPhoto().getBig(), getContext());
                                            // firebaseMethods.registerUser(email.getText().toString(), passwd.getText().toString(), username.getText().toString(), laLigaPlayer.getPhotos().getPhoto().getBig(), getContext());
                                            progressDialog.dismiss();
                                        }
                                    }, 1000);

                            //mostrarError(mensaje);
//                            getActivity().getSupportFragmentManager()
//                                    .beginTransaction()
//                                    .replace(R.id.main_content, FragmentoMenu.newInstance(null))
//                                    .commit();
                        } else {
//                        La contraseña minimo son 6 caracteres para firebase
                            mostrarError(getString(R.string.password_characters));
                        }

                    } else {
//                        La contraseñas no coinciden
                        mostrarError(getString(R.string.passwords_not_match));
                    }
                } else {
                    mostrarError(getString(R.string.invalid_email));
                }

            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signInGoogle(getContext());


            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LaLigaPlayer laLigaPlayer = (LaLigaPlayer) spinner.getSelectedItem();
                Glide.with(getContext()).load(laLigaPlayer.getPhotos().getPhoto().getBig()).into(circleImageView);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    private void populateSpinner() {
        generateImageUrl = new GenerateImageUrl();

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

        ArrayAdapter<LaLigaPlayer> adapter = new ArrayAdapter<LaLigaPlayer>(getContext(), R.layout.list_spinner, laLigaPlayers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


    }

    public void mostrarError(String mensaje) {
        txtError.setText(mensaje);
        txtError.setVisibility(View.VISIBLE);
    }

    public static boolean isEmailValid(String email) {
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void initComponents(View view) {

        email = view.findViewById(R.id.txtRegisterEmail);
        passwd = view.findViewById(R.id.txtRegisterPasswd);
        passwd2 = view.findViewById(R.id.txtRegisterConfirmPasswd);
        btnRegister = view.findViewById(R.id.btnRegister);
        txtError = view.findViewById(R.id.txtErrorRegister);
        username = view.findViewById(R.id.txtRegisterUserName);
        circleImageView = view.findViewById(R.id.ivAvatarRegister);
        spinner = view.findViewById(R.id.spinnerRegisterAvatar);
        goToLogin = view.findViewById(R.id.txtGoToLogin);
        btnGoogle = view.findViewById(R.id.btnLogInGoogle);


    }

    public TextView getTxtError() {
        return txtError;
    }

    public void setTxtError(TextView txtError) {
        this.txtError = txtError;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    private void goToLogin() {
        FragmentoLogin fragmentoLogin = FragmentoLogin.newInstance(null);


        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_content, fragmentoLogin, "findThisFragment")
                .addToBackStack(null)
                .commit();
    }
}
