package com.example.scanlive.actvities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.scanlive.Adapters.AdaptadorTips;
import com.example.scanlive.R;

public class ListadoTipsActivity extends AppCompatActivity {

    ListView lista;

    String[][] datos = {

            //la calificacion va entre 1 - 10
            // titulo, director, duracion, calificacion, url
            {"Cuidado de mascotas en el hogar","Agenda semanal piura","06:26","8","UYXi8f4Hpms"},
            {"Los 10 perros mas cariñosos del mundo","TopMax","12:20","9","PcB1nNDm8Zo"},
            {"Cuidado de mascotas en el hogar","Agenda semanal piura","06:26","8","UYXi8f4Hpms"},
            {"Los 10 perros mas cariñosos del mundo","TopMax","12:20","9","PcB1nNDm8Zo"},
            {"titulo","director","00:25","2","tQWIXImawgA"}



    };
    int [] datosImg = {R.drawable.mascotauno, R.drawable.mascotados, R.drawable.mascotauno, R.drawable.mascotados, R.drawable.userphoto};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_tips);

        lista = findViewById(R.id.lvLista);

        lista.setAdapter(new AdaptadorTips(this, datos, datosImg));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent visorVideo =new Intent(view.getContext(), YoutubeActivity.class);
                visorVideo.putExtra("TIT",datos[i][0]);
                visorVideo.putExtra("URL", datos[i][4]);
                startActivity(visorVideo);
            }
        });

    }
}
