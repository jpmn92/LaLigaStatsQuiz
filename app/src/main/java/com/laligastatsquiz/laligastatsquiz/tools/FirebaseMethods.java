package com.laligastatsquiz.laligastatsquiz.tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Timestamp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;
import com.laligastatsquiz.laligastatsquiz.beans.Codigo;
import com.laligastatsquiz.laligastatsquiz.beans.FirebasePuntuacion;
import com.laligastatsquiz.laligastatsquiz.fragments.FragmentoAccount;
import com.laligastatsquiz.laligastatsquiz.fragments.FragmentoMenu;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoAutentificacion;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoLogin;
import com.laligastatsquiz.laligastatsquiz.fragments.auth.FragmentoRegister;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FirebaseMethods {

    private final int LIMITE_PUNTUACIONES = 100;

    Fragment fragment;
    GameActivity gameActivity;
    Context context;
    Boolean processDone;
    DatabaseReference reference;
    FirebasePuntuacion fbPuntuacion;
    Bundle bundlePartida;
    int puntuacion, puntosTotales;
    ArrayList<FirebasePuntuacion> listadoFinal;
    SessionManagement sessionManagement;
    public FirebaseMethods(Fragment fragment) {
        this.fragment = fragment;
    }

    public FirebaseMethods(GameActivity gameActivity, Bundle bundlePartida) {
        this.gameActivity = gameActivity;
        this.bundlePartida = bundlePartida;
        this.puntuacion = 0;
    }

    public void createFbPuntuacion(Bundle bundle) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        String hour = "";

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDateTime currentHour = LocalDateTime.now();
            hour = currentHour.getHour() + ":" + currentHour.getMinute() + ":" + currentHour.getSecond();
        }

        //NUEVO FORMATO DE FECHA
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        String formatedDate = simpleDateFormat.format(new Date());

        // Map<String, String> timestamp = ServerValue.TIMESTAMP;
        Timestamp timestamp = new Timestamp(new Date());

        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        String uid = mAuth.getUid();


        fbPuntuacion = new FirebasePuntuacion();

        fbPuntuacion.setPoints(bundle.getInt("puntos"));
        fbPuntuacion.setDate(currentDate);
        fbPuntuacion.setHour(hour);
        fbPuntuacion.setLiga(bundle.getString("ligaPuntuacion"));
        //fbPuntuacion.setLiga(bundle.getString("liga"));
        fbPuntuacion.setSeason(bundle.getString("season"));
        fbPuntuacion.setStatCategory(String.valueOf(bundle.getInt("statId")));
        fbPuntuacion.setImage(bundle.getString("image"));
        fbPuntuacion.setUid(uid);
        fbPuntuacion.setUsername(bundle.getString("userName"));
        fbPuntuacion.setTimestamp(timestamp);

        db.collection("Puntuacion")
                .add(fbPuntuacion)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("TAG", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("TAG", "Error adding document", e);
                    }
                });

    }

    public void getRecord() {
        ArrayList<FirebasePuntuacion> mArrayList = new ArrayList<>();

        ArrayList<FirebasePuntuacion> fbPuntuacionList = new ArrayList<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        CollectionReference puntuacionesRef = db.collection("Puntuacion");

        String stat =  String.valueOf(bundlePartida.getInt("statId"));

        puntuacionesRef.whereEqualTo("season", bundlePartida.getString("season"))
                //.whereEqualTo("liga", bundlePartida.getString("liga"))
                .whereEqualTo("liga", bundlePartida.getString("ligaPuntuacion"))
                .whereEqualTo("statCategory", stat)
                .whereEqualTo("uid", mAuth.getUid()).whereGreaterThan("points", -1)
                .orderBy("points", Query.Direction.DESCENDING).limit(1).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // Convert the whole Query Snapshot to a list
                // of objects directly! No need to fetch each
                // document.
                List<FirebasePuntuacion> fbPuntuaciones = queryDocumentSnapshots.toObjects(FirebasePuntuacion.class);

                mArrayList.addAll(fbPuntuaciones);
                // Add all to your list
                Log.d("TAG", "onSuccess: " + mArrayList);

                if(fbPuntuaciones.size() > 0 ) {
                    puntuacion = fbPuntuaciones.get(0).getPoints();
                }
                gameActivity.setRecord(puntuacion);
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        System.out.println("");//Toast.makeText(getApplicationContext(), "Error getting data!!!", Toast.LENGTH_LONG).show();
                    }
                });
    }

    //SI LO HACEMOS ARRAYLIST NO VA
    public void getTopPuntuaciones(Bundle paramsPartida) {

        ArrayList<FirebasePuntuacion> mArrayList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        String stat = String.valueOf(paramsPartida.getInt("statId"));
        String liga = paramsPartida.getString("liga");
        String season = paramsPartida.getString("season");

        CollectionReference puntuacionesRef = db.collection("Puntuacion");

        puntuacionesRef.whereEqualTo("season", paramsPartida.getString("season"))
                .whereEqualTo("liga", paramsPartida.getString("ligaPuntuacion"))
                .whereEqualTo("statCategory", stat)
                .whereGreaterThan("points", -1)
                .orderBy("points", Query.Direction.DESCENDING).limit(LIMITE_PUNTUACIONES).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                // Convert the whole Query Snapshot to a list
                // of objects directly! No need to fetch each
                // document.
                List<FirebasePuntuacion> fbPuntuaciones = queryDocumentSnapshots.toObjects(FirebasePuntuacion.class);

                // Add all to your list
                mArrayList.addAll(fbPuntuaciones);
                Log.d("TAG", "onSuccess: " + mArrayList);

                FragmentoMenu fragmentoMenu = (FragmentoMenu) fragment;
                fragmentoMenu.setPuntuaciones(mArrayList);

                getPersonalRecordFS(paramsPartida);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Toast.makeText(getApplicationContext(), "Error getting data!!!", Toast.LENGTH_LONG).show();
                System.out.println("");
            }
        });
    }

    public void getPersonalRecordFS(Bundle bundle) {

        ArrayList<FirebasePuntuacion> mArrayList = new ArrayList<>();
//        reference = FirebaseDatabase.getInstance().getReference().child("Puntuacion");

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        String stat = String.valueOf(bundle.getInt("statId"));

        CollectionReference puntuacionesRef = db.collection("Puntuacion");

        puntuacionesRef.whereEqualTo("season", bundle.getString("season"))
                .whereEqualTo("liga", bundle.getString("ligaPuntuacion"))
                .whereEqualTo("statCategory", stat)
                .whereEqualTo("uid", mAuth.getUid()).whereGreaterThan("points", -1)
                .orderBy("points", Query.Direction.DESCENDING).limit(1).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // Convert the whole Query Snapshot to a list
                // of objects directly! No need to fetch each
                // document.
                List<FirebasePuntuacion> fbPuntuaciones = queryDocumentSnapshots.toObjects(FirebasePuntuacion.class);

                // Add all to your list
                mArrayList.addAll(fbPuntuaciones);
                Log.d("TAG", "onSuccess: " + mArrayList);

                FragmentoMenu fragmentoMenu = (FragmentoMenu) fragment;

                fragmentoMenu.setPuntuacionPersonal(mArrayList);
                fragmentoMenu.goToPuntuaciones();

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("");
                        //Toast.makeText(getApplicationContext(), "Error getting data!!!", Toast.LENGTH_LONG).show();
                    }
                });

    }

    public void registerUser(String email, String passwd, String username, String urlImage, Context RegisterContext) {
        FragmentoRegister fragmentoRegister = (FragmentoRegister) fragment;
        FirebaseAuth mAuth;
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        mAuth.createUserWithEmailAndPassword(email, passwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    String id = mAuth.getCurrentUser().getUid();

                    FirebaseUser myUser = mAuth.getCurrentUser();

//                                myUser.sendEmailVerification();


                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                            .setDisplayName(username).setPhotoUri(Uri.parse(urlImage)).build();

                    myUser.updateProfile(profileUpdates)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task3) {
                                    if (task3.isSuccessful()) {
                                        //USERNAME ACTUALIZADO
                                        String OK = "OK";
                                        //TODO: loguear de otra manera mas limpia
                                        logIn(myUser, RegisterContext);


                                    } else {
                                        //no se le ha asignado el username
                                        String NOOK = "NOOK";
                                    }
                                }
                            });

                } else {

                    fragmentoRegister.mostrarError(fragmentoRegister.getString(R.string.already_registred));
//                    no se ha podido crear el usuario

                }
            }
        });
    }

    public void logIn(String email, String password, Context loginContext) {
        FragmentoLogin fragmentoLogin = (FragmentoLogin) fragment;
        FirebaseAuth mAuth;

        sessionManagement = new SessionManagement(loginContext);
        mAuth = FirebaseAuth.getInstance();
        reference = FirebaseDatabase.getInstance().getReference();
        try {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        //TODO: Inicias sesión correctamete
                        FirebaseUser user = mAuth.getCurrentUser();

                        String urlAvatar = user.getPhotoUrl().toString();

                        sessionManagement.saveSession(user.getDisplayName(), user.getEmail(), urlAvatar);
//                        Toast.makeText(loginContext, R.string.login_correcto + " " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
                        goToMenu(user.getDisplayName());


                    } else {
                        // If sign in fails, display a message to the user.
                        //TODO: Error en inicio de sesión
                        // Toast.makeText(loginContext, getString(R.string.login_incorrecto), Toast.LENGTH_SHORT).show();
                        try{

                            task.getResult();
                        } catch (Exception e){
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                            fragmentoLogin.getTxtErrorLogIn().setText(loginContext.getString(R.string.login_incorrecto));
                            fragmentoLogin.getTxtErrorLogIn().setVisibility(View.VISIBLE);
                        }

                    }

                }
            });
        } catch (IllegalArgumentException e) {
            Toast.makeText(fragmentoLogin.getContext(), "Campos de texto vacios", Toast.LENGTH_SHORT).show();
        }

    }

    public void logIn(FirebaseUser myUser, Context loginContext) {
        System.out.println(myUser.getDisplayName());
        System.out.println(myUser.getEmail());
        System.out.println(myUser.getPhotoUrl());
        sessionManagement = new SessionManagement(loginContext);
        reference = FirebaseDatabase.getInstance().getReference();

        //sessionManagement.saveSession(myUser.getDisplayName(), myUser.getEmail(), myUser.getPhotoUrl().toString());


        goToMenu(myUser.getDisplayName());


    }

    public void goToMenu(String userName) {
        FragmentoMenu goToMenu = FragmentoMenu.newInstance(null);
        FragmentoAutentificacion fragmentoAutentificacion = (FragmentoAutentificacion) fragment;
        String message = "";
        //si viene de login que utilice su contexto

        if (fragmentoAutentificacion != null) {


            fragmentoAutentificacion.getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content, goToMenu, "findThisFragment")
                    .addToBackStack(null)
                    .commit();
            message = fragmentoAutentificacion.getString(R.string.login_correcto);
            Toast.makeText(fragmentoAutentificacion.getContext(), message + ", " + userName, Toast.LENGTH_SHORT).show();


        } else {
//            //si viene de register que utilice su contexto
//            if (fragmentoRegister != null) {
//                fragmentoRegister.getActivity().getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.main_content, goToMenu, "findThisFragment")
//                        .addToBackStack(null)
//                        .commit();
//                message = fragmentoRegister.getString(R.string.registro_correcto);
//
//                Toast.makeText(fragmentoRegister.getContext(), message + ", " + userName, Toast.LENGTH_SHORT).show();
            // Toast.makeText(fragmentoRegister.getContext(), getString(R.string.login_incorrecto), Toast.LENGTH_SHORT).show();
//
        }
//        }
    }

    public void updateUser(String userName, String urlImage, Context avatarContext) {
        FirebaseAuth mAuth;
        sessionManagement = new SessionManagement(avatarContext);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser avatarUser = mAuth.getCurrentUser();


        UserProfileChangeRequest avatarUpdates = new UserProfileChangeRequest.Builder().
                setPhotoUri(Uri.parse(urlImage)).setDisplayName(userName).build();

        avatarUser.updateProfile(avatarUpdates)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task3) {
                        if (task3.isSuccessful()) {
                            //AVATAR ACTUALIZADO
//                            Toast.makeText(context, R.string.config_updated, Toast.LENGTH_SHORT).show();
                            Toast.makeText(avatarContext, R.string.config_updated, Toast.LENGTH_SHORT).show();
                            changeImageRecord(avatarUser);


                        } else {
                            //no se le ha asignado el avatar
                            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }


                });
    }

    private void changeImageRecord(FirebaseUser user) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        CollectionReference puntuacionesRef = db.collection("Puntuacion");

        String uid = user.getUid();

        puntuacionesRef
                .whereEqualTo("uid", user.getUid()).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                // Convert the whole Query Snapshot to a list
                // of objects directly! No need to fetch each
                // document.
                if (!queryDocumentSnapshots.isEmpty()) {
                    for (QueryDocumentSnapshot querySnapshot : queryDocumentSnapshots) {
                        Map puntuacionCambio = new HashMap<String, Object>();
                        puntuacionCambio.put("image", String.valueOf(user.getPhotoUrl()));
                        puntuacionCambio.put("username", String.valueOf(user.getDisplayName()));
                        db.collection("Puntuacion").document(querySnapshot.getId()).update(puntuacionCambio);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("");
                // Toast.makeText(getApplicationContext(), "Error getting data!!!", Toast.LENGTH_LONG).show();
            }
        });

    }

    //METODO PARA RECOGER LAS IMAGENES DE LOS USUARIOS
    public void getUser(String email) {


    }

    private void toastAutentificacion(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


    public void getUserAverage(FirebaseUser user) {
        processDone = false;
        puntosTotales = 0;
        ArrayList<FirebasePuntuacion> fbPuntuacionList = new ArrayList<>();
        ArrayList<FirebasePuntuacion> fbMisPuntuaciones = new ArrayList<>();

        ArrayList<DataSnapshot> dataSnapshotArrayList = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference().child("Puntuacion");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (!processDone) {

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        Object object = snapshot.getValue(Object.class);
                        String json = new Gson().toJson(object);
                        FirebasePuntuacion fbPuntuacion = new Gson().fromJson(json, FirebasePuntuacion.class);
                        fbPuntuacionList.add(fbPuntuacion);
                        dataSnapshotArrayList.add(dataSnapshot.child(snapshot.getKey()));


                    }

                    for (int i = 0; i < fbPuntuacionList.size(); i++) {

                        fbPuntuacionList.get(i);

                        String uidActual = user.getUid();
                        String uidPuntuacion = fbPuntuacionList.get(i).getUid();

                        if (uidActual.equals(uidPuntuacion)) {

                            fbMisPuntuaciones.add(fbPuntuacionList.get(i));
                            puntosTotales = puntosTotales + fbPuntuacionList.get(i).getPoints();


                        }


                    }

                    double media = (puntosTotales / fbMisPuntuaciones.size());


                    processDone = true;


                }


            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }


        });
    }

    public void readCode(String codigo, FragmentoAccount fragmentoAccount){

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        final String[] url = {""};

        CollectionReference codigosRef = db.collection("Codigo");

        codigosRef.whereEqualTo("codigo", codigo)
                .get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                List<Codigo> codigos = queryDocumentSnapshots.toObjects(Codigo.class);
                if(codigos.size() > 0){
                    url[0] = codigos.get(0).getUrl();

                    if(!"".equalsIgnoreCase(url[0])){
                        fragmentoAccount.urlCode(url[0]);
                    }
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                System.out.println("");
                //Toast.makeText(getApplicationContext(), "Error getting data!!!", Toast.LENGTH_LONG).show();
            }
        });
    }
}
