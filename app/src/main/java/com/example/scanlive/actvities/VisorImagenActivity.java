package com.example.scanlive.actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.scanlive.R;

public class VisorImagenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_imagen);

        ImageView img = findViewById(R.id.ivImagenCompleta);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b!=null){
            img.setImageResource(b.getInt("IMG"));
        }

    }
}
