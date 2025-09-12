package com.example.miprimeraaplicacin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        val btnSpinner: Button = findViewById(R.id.btn_spinner)
        val SpinrShow : Spinner = findViewById(R.id.sd_spinner)
        val Lsview : ListView = findViewById(R.id.lst_view)

        val opcionesSpinner = arrayOf(
            "Sumar",
            "Restar",
            "Multiplicar",
            "Dividir")

        val adaptador = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, opcionesSpinner)


                    SpinrShow.adapter = adaptador


        val opcionesListView = arrayOf(
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Eleven",

        )

        val adaptador2 = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, opcionesListView)

                    Lsview.adapter = adaptador2
        var str_op_selected =  SpinrShow.selectedItem.toString()
       btnSpinner.setOnClickListener {
           val toast = Toast.makeText(
               this, //"mensaje",
               str_op_selected,
               Toast.LENGTH_SHORT
           )
           toast.show()
       }







        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}