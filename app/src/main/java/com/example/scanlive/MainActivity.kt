package com.example.scanlive

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.scanlive.actvities.ListadoTipsActivity
import com.example.scanlive.actvities.LoginActivity
import com.example.scanlive.actvities.RegisterActivity
import com.example.scanlive.actvities.YoutubeActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {



        /**llamado de splashscreen y tiempo de duracion**/
        Thread.sleep(1500)
        setTheme(R.style.AppTheme)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_scanPet.setOnClickListener { abrirScaners() }
        btn_send.setOnClickListener { enviarMensaje() }
        btn_Tips.setOnClickListener { abrirTips() }
        btn_scanWhatsapp.setOnClickListener{ abrirWhatsapp()}
    }


    /****** mostrar menu superior boton regresar  */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_add, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.add_phrase -> {
                Log.i("ActionBar", "Add Phrase!")
                val AddPhrase = Intent( applicationContext, MainActivity::class.java) //layout que quieras abrir
                startActivity(AddPhrase)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun abrirScaners() {
        val scaner = Intent(this, EscanerActivity::class.java)
        startActivity(scaner)
    }

    fun enviarMensaje() {

        val mensaje = Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/105460394155905"))
        startActivity(mensaje)
    }

    fun abrirTips() {
        //val tips = Intent(this, TipsActivity::class.java)
        //val tips = Intent(this, RegisterActivity::class.java)
        //val tips = Intent(this, YoutubeActivity::class.java)
        val tips = Intent(this, ListadoTipsActivity::class.java)
        startActivity(tips)
    }

    fun abrirWhatsapp(){
        val whatsapp = Intent(this, MainActivity::class.java)
        startActivity(whatsapp)
    }





    /***** fin menu superior  ***/
}
