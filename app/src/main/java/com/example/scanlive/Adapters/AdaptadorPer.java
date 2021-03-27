package com.example.scanlive.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.scanlive.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

public class AdaptadorPer extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    JSONArray datosJSON;


    public AdaptadorPer(Context contexto, JSONArray datosJSON){

        this.contexto = contexto;
        this.datosJSON = datosJSON;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.elemento_lista_per,null);
        TextView lbNomMascota = view.findViewById(R.id.lbNomMascota);
        TextView lbNomPropietario = view.findViewById(R.id.lbNomPropietario);
        TextView lbDireccion = view.findViewById(R.id.lbDireccion);
        TextView lbTelefono = view.findViewById(R.id.lbTelefono);
        TextView lbVacunas = view.findViewById(R.id.lbVacunas);
        TextView lbNotas = view.findViewById(R.id.lbNotas);
        ImageView imgFoto = view.findViewById(R.id.imgFoto);
        String url="https://cflvdg.avoz.es/default/2019/08/27/00121566894722496465478/Foto/XG27C6F7_103117.jpg";

        try {
            lbNomMascota.setText(datosJSON.getJSONObject(position).getString("nomMascota"));
            lbNomPropietario.setText(datosJSON.getJSONObject(position).getString("nomPropietario"));
            lbTelefono.setText(datosJSON.getJSONObject(position).getString("telefono"));
            lbDireccion.setText(datosJSON.getJSONObject(position).getString("direccion"));
            lbVacunas.setText(datosJSON.getJSONObject(position).getString("vacunas"));
            lbNotas.setText(datosJSON.getJSONObject(position).getString("notas"));
            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.icon_users)
                    //.error(R.drawable.ic_cancel_black)
                    .into(imgFoto);
/*
            String estado = lbEstado.getText().toString();
            String placa = lbNumPlaca.getText().toString();

                if  (estado.equals("ALDIA")){
                    lbEstado.setBackgroundColor(Color.GREEN);
                    lbNumPlaca.setBackgroundColor(Color.GREEN);
                    lbNombre.setBackgroundColor(Color.GREEN);
                }else  if  (estado.equals("AL DIA")){
                    lbEstado.setBackgroundColor(Color.GREEN);
                    lbNumPlaca.setBackgroundColor(Color.GREEN);
                    lbNombre.setBackgroundColor(Color.GREEN);
                }else if (estado.equals("PENDIENTE")){
                    lbEstado.setBackgroundColor(Color.RED);
                    lbNumPlaca.setBackgroundColor(Color.RED);
                    lbNombre.setBackgroundColor(Color.RED);
                }
*/


        }catch (Exception e1){

        }


        return view;
    }
    @Override
    public int getCount() {
        return datosJSON.length();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


}
