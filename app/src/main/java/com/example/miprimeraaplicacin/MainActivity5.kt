package com.example.miprimeraaplicacin

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miprimeraaplicacin.API.InsertarAlumnosAPI
import com.example.miprimeraaplicacin.ApRegionComuna.CargarRegionComunaAPI

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        val spGrupo: Spinner = findViewById(R.id.sp_grupo)
        val spSeccion: Spinner = findViewById(R.id.sp_seccion)
        val btnAccion: Button = findViewById(R.id.btn_actspin)
        val edNombre : EditText = findViewById(R.id.ed_nom)
        val edApellido : EditText = findViewById(R.id.ed_apel)
        CargarRegionComunaAPI.cargarRegionComuna(this,spGrupo)
        CargarRegionComunaAPI.cargarRegionComuna2(this,spSeccion)

        val opcionesSpinnerGrup = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13",
            "14",
            "15",
            )
        val opcionesSpinnerSecc = listOf(
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
        )

        val adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, opcionesSpinnerGrup).apply()
        {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        spGrupo.adapter = adapter

        val adapter2 = ArrayAdapter(
            this, android.R.layout.simple_spinner_item, opcionesSpinnerSecc).apply()
        {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }


        spSeccion.adapter = adapter2



        btnAccion.setOnClickListener{
          InsertarAlumnosAPI.insertarAlumno(
           owner = this,
           context = this,
           nombre = edNombre.text.toString(),
           apellido = edApellido.text.toString(),
           grupo =  spGrupo.selectedItem.toString(),
           seccion = spSeccion.selectedItem.toString(),
           archivoBytes = null,
           onSuccess = {
               println("termino insert correcto")
               Toast.makeText(this
                   , "guardado"
                   , Toast.LENGTH_SHORT)
           },
              onError = {
                  println("Termino Insert Incorrecto")
                  Toast.makeText(this, "NO GUARDADO",Toast.LENGTH_SHORT)
              }
          )
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}