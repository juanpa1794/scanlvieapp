package com.example.scanlive;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.scanlive.Adapters.AdaptadorPer;
import com.example.scanlive.Adapters.AdaptadorPet;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class MostrarPerActivity extends AppCompatActivity {

    ListView listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_per);

        /** mostramos el titulo en el builder*/
        getSupportActionBar().setTitle("Informacion Personas");

        /** llamar listado y mostrar datos en el listvies */
        listado = findViewById(R.id.listado);
        ObtDatos();

    }



    public void ObtDatos(){
        AsyncHttpClient client = new AsyncHttpClient();

        //hacer pruebas con el webservices http://scanlive.com.co/WebService/valida.php?idMascota=balu1085311774


        //link scanlivepets
        String url = "http://scanlive.com.co/appServices/WebService/valida.php";

        RequestParams parametros = new RequestParams();
        //parametros.put("numPlaca",getIntent().getExtras().getString("buscar"));
        parametros.put("idMascota",getIntent().getExtras().getString("parametro"));


        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){

                    cargarDatos(statusCode,new String(responseBody));

                }


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {


            }
        });


    }

    public void cargarDatos(int statusCode, String response){
        if (statusCode==200){
            try {
                JSONArray datosJSON = new JSONArray((response));
                listado.setAdapter(new AdaptadorPer(this, datosJSON));
            }catch (Exception e){
                Toast.makeText(MostrarPerActivity.this, "El numero de placa no Existe", Toast.LENGTH_SHORT).show();

            }
        }


    }




}
