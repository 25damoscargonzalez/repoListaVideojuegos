package com.example.androidProyect

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidProyect.datos.RepositorioSingleton

class ConsolaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idConsola = intent.extras?.getInt("numero")?:0
        enableEdgeToEdge()
        setContentView(R.layout.activity_consola)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lista = RepositorioSingleton.instance.listaConsolas
        val consola = lista.buscar(idConsola)
        findViewById<TextView>(R.id.tarjetaNombre).text = consola.nombre

        val icono = findViewById<ImageView>(R.id.iconoGrande)
        val draw = AppCompatResources.getDrawable(this, consola.imagen)
        icono.setImageDrawable(draw)

        val textAlmacenamiento = findViewById<TextView>(R.id.tarjetaAlmacenamiento)
        val textoFecha = findViewById<TextView>(R.id.tarjetaFecha)
        val textoEmpresa = findViewById<TextView>(R.id.tarjetaEmpresa)
        val textoDescripcion = findViewById<TextView>(R.id.tarjetaDescripcion)

        textAlmacenamiento.text =  consola.Almacenamiento.toString()
        textoFecha.text = consola.FechaLanzamiento.toString()
        textoEmpresa.text = consola.Empresa.toString()
        textoDescripcion.text = consola.descripcion

        val ratingBar = findViewById<RatingBar>(R.id.tarjetaOpinion)
        ratingBar.rating = consola.opinion.toFloat()

    }
}