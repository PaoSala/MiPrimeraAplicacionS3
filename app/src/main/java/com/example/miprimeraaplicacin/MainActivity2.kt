package com.example.miprimeraaplicacin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val txUsuario:TextView =findViewById(R.id.id_usuario_loggeado)
        val recibirUsernameS = intent.getStringExtra("par_usern")
        val btnMenReg : Button = findViewById(R.id.btn_men_Reg_Com)
        val btnGoCam : Button = findViewById(R.id.btn_go_cam)
        val btnGoCalculadora : Button = findViewById(R.id.btn_calculadora)
        val btnMenu:Button = findViewById(R.id.btn_menuprincipal)
        txUsuario.text = recibirUsernameS.toString()
        btnGoCalculadora.setOnClickListener {
            val nuevaVentana2 = Intent(this, MainActivity3::class.java)
            startActivity(nuevaVentana2)
        }
        btnMenu.setOnClickListener {
            val nuevaVentana3 = Intent(this, MainActivity4::class.java)
            startActivity(nuevaVentana3)
        }
        btnMenReg.setOnClickListener {
            val nuevaVentana4 = Intent(this, MainActivity5::class.java)
            startActivity(nuevaVentana4)
        }
        btnGoCam.setOnClickListener {
            val nuevaVentana5 = Intent(this, MainActivity7::class.java)
            startActivity(nuevaVentana5)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}