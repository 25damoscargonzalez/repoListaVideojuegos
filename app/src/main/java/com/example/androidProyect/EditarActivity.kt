package com.example.androidProyect

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidProyect.datos.RepositorioSingleton

class EditarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_editar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idConsola = intent.extras?.getInt("numero Consola")

        if (idConsola != null){
            var consola = RepositorioSingleton.instance.listaConsolas.buscar(idConsola)
            val nom = findViewById<EditText>(R.id.editNombre)
            nom.setText(consola.nombre)

            val alm = findViewById<EditText>(R.id.editAlmacenamiento)
            alm.setText(consola.almacenamiento.toString())

            val fecha = findViewById<EditText>(R.id.editFechaLanzamiento)
            fecha.setText(consola.fechaLanzamiento.toString())

            val emp = findViewById<EditText>(R.id.editEmpresa)
            emp.setText(consola.empresa.toString())

            val rating = findViewById<RatingBar>(R.id.editOpinion)
            rating.rating = consola.opinion.toFloat()

            val desc = findViewById<EditText>(R.id.editDescripcion)
            desc.setText(consola.descripcion)

            findViewById<Button>(R.id.bGuardar).setOnClickListener {
                consola.nombre = nom.text.toString()
                consola.almacenamiento = alm.text.toString().toFloat()
                consola.descripcion = desc.text.toString()
                consola.opinion = rating.rating.toInt()
                RepositorioSingleton.instance.listaConsolas.actualizar(idConsola, consola)
            }
        } else{

        }

    }
}