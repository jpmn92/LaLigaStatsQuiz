package com.laligastatsquiz.laligastatsquiz.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.laligastatsquiz.laligastatsquiz.GameActivity;
import com.laligastatsquiz.laligastatsquiz.R;

public class FragmentoMenu extends AppCompatActivity implements View.OnClickListener {
    Button btComenzar, btPuntuaciones;
    Spinner spinnerStats;
    ImageView ivSound;
    boolean sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_fragmento_menu);

        initComponents();
    }

    private void initComponents() {
        btComenzar = findViewById(R.id.btnStart);
        btComenzar.setOnClickListener(this);
        btPuntuaciones = findViewById(R.id.btnRecords);
        spinnerStats = findViewById(R.id.spinnerStats);
        ivSound = findViewById(R.id.ivSound);
        ivSound.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(sound){
                    sound = false;
                    ivSound.setImageResource(R.drawable.volume_off);
                }
                else{
                    sound = true;
                    ivSound.setImageResource(R.drawable.volume_on);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                //params.putString("stat", String.valueOf(spinnerStats.getSelectedItem()));
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("stat", String.valueOf(spinnerStats.getSelectedItem()));
                intent.putExtra("sound", sound);
                this.startActivity(intent);
                break;
        }
    }
}
