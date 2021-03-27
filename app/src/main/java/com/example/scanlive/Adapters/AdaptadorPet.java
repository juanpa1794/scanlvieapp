package com.example.scanlive.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scanlive.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;

public class AdaptadorPet extends BaseAdapter {

    private static LayoutInflater inflater = null;
    Context contexto;
    JSONArray datosJSON;
    TextView telefono;



    public AdaptadorPet(Context contexto, JSONArray datosJSON){

        this.contexto = contexto;
        this.datosJSON = datosJSON;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);

    }



   @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View view = inflater.inflate(R.layout.elemento_lista_pet,null);
        TextView lbNomMascota = view.findViewById(R.id.lbNomMascota);
        TextView lbNomPropietario = view.findViewById(R.id.lbNomPropietario);
        TextView lbDireccion = view.findViewById(R.id.lbDireccion);
        TextView lbTelefono = view.findViewById(R.id.lbTelefono);
        TextView lbVacunas = view.findViewById(R.id.lbVacunas);
        TextView lbNotas = view.findViewById(R.id.lbNotas);
        ImageView imgFoto = view.findViewById(R.id.imgFoto);
        Button btnWhatsapp = view.findViewById(R.id.btnWhatsapp);
        String telefono = null;
       final String finalTelefono;


        try {
            lbNomMascota.setText(datosJSON.getJSONObject(position).getString("nomMascota"));
            lbNomPropietario.setText(datosJSON.getJSONObject(position).getString("nomPropietario"));
            lbTelefono.setText(datosJSON.getJSONObject(position).getString("telefono"));
            lbDireccion.setText(datosJSON.getJSONObject(position).getString("direccion"));
            lbVacunas.setText(datosJSON.getJSONObject(position).getString("vacunas"));
            lbNotas.setText(datosJSON.getJSONObject(position).getString("notas"));
            String Fotos = datosJSON.getJSONObject(position).getString("fotos");
            final String url ="https://app.scanlive.co/php/Fotos/"+Fotos;
            Toast.makeText(contexto, ""+url, Toast.LENGTH_LONG).show();


            Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.pet_icon)
                    //.error(R.drawable.ic_cancel_black)
                    .into(imgFoto);



            telefono = lbTelefono.getText().toString();
            finalTelefono = telefono;


            btnWhatsapp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        String text = "Encontre a tu mascota\n click en el link para ver la imagen \n";
                        String numero = "573192488136";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+ "57"+ finalTelefono +"&text="+text+url));

                        intent.setPackage("com.whatsapp");
                        contexto.startActivity(intent);
                    }catch (Exception e){
                        Toast.makeText(view.getContext(), "No tiene instalado Whatsapp", Toast.LENGTH_SHORT).show();

                    };
                }
            });



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
