package com.example.miprimeraaplicacin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacin.funciones.OpMatematicas

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        val ednumcal1: EditText = findViewById(R.id.ed_num1)
        val ednumcal2: EditText = findViewById(R.id.ed_num2)
        val btnCalc: Button = findViewById(R.id.btncalcular)
        val txNumCalc: TextView = findViewById(R.id.txtNumRec)



        btnCalc.setOnClickListener {
            var numeroUno: Int = ednumcal1.text.toString().toIntOrNull() ?: 0
            var numeroDos: Int = ednumcal2.text.toString().toIntOrNull() ?: 0

            txNumCalc.text = OpMatematicas.dividirValores(numeroUno, numeroDos)

            // txMensaje.text = edUsername.text.toString()
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}