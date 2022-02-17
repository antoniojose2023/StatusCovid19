package br.com.antoniojoseuchoa.statuscovid19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    lateinit var button_image_pais: ImageButton
    lateinit var button_image_estados: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_image_pais = findViewById(R.id.iv_button_pais)
        button_image_estados = findViewById(R.id.iv_button_estados)

        button_image_pais.setOnClickListener {
            startActivity(Intent(this, PaisActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        button_image_estados.setOnClickListener {
            startActivity(Intent(this, EstadosActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

    }


}