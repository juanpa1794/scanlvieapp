package com.example.scanlive.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.scanlive.R;
import com.example.scanlive.actvities.VisorImagenActivity;

public class AdaptadorTips extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    String[][] datos;
    int[] datosImg;

    public AdaptadorTips (Context context, String[][] datos, int[] imagenes){


        this.contexto = context;
        this.datos = datos;
        this.datosImg = imagenes;
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);


    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista_tips, null);

        //IN
        TextView titulo = vista.findViewById(R.id.txtTituloPel);
        TextView duracion = vista.findViewById(R.id.txtDuracion);
        TextView director = vista.findViewById(R.id.txtDirector);
        ImageView imagen = vista.findViewById(R.id.imgPeli);
        RatingBar calificacion = vista.findViewById(R.id.ratingBarPel);

        //Asignacion de valores
        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        duracion.setText("Duracion: "+datos[i][2]);
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));
        imagen.setTag(i);

        //Mostrar imagen en tamaño grande

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visorImagen =new Intent(contexto, VisorImagenActivity.class);
                visorImagen.putExtra("IMG", datosImg[(Integer) view.getTag()]);
                contexto.startActivity(visorImagen);
            }
        });




        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
