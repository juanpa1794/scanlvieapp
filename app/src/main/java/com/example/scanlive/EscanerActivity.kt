package com.example.scanlive

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class EscanerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escaner)
        /**mostramos el titulo en el builder*/
        getSupportActionBar()?.setTitle("Escaner")


        /**botones de acceso a los escaneres*/
        btn_scanPet.setOnClickListener {

            abrirScanerPet()
        }
        btn_scanWhatsapp.setOnClickListener {
            abrirScanerPer()
        }
    }

    private fun abrirScanerPer() {
        val intentPer = Intent(this, PerQRActivity::class.java)
        startActivity(intentPer)
    }


    fun abrirScanerPet() {
        val intentPet = Intent(this, PetQRActivity::class.java)
        startActivity(intentPet)
    }





}
