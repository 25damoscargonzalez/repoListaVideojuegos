package com.example.androidProyect

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidProyect.datos.RepositorioSingleton

class ConsolaActivity : AppCompatActivity() {
    companion object {
        const val NUMERO_CONS = "numero consola"
    }

    var idConsola: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idConsola = intent.extras?.getInt(NUMERO_CONS) ?:0
        enableEdgeToEdge()
        setContentView(R.layout.activity_consola)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val barra = findViewById<Toolbar>(R.id.toolbar_consola)
        setSupportActionBar(barra)

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

        textAlmacenamiento.text =  consola.almacenamiento.toString()
        textoFecha.text = consola.fechaLanzamiento.toString()
        textoEmpresa.text = consola.empresa.toString()
        textoDescripcion.text = consola.descripcion

        val ratingBar = findViewById<RatingBar>(R.id.tarjetaOpinion)
        ratingBar.rating = consola.opinion.toFloat()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_vista_consola, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d("MENU", "PULSADO EL $item")

        val idBoton = item.itemId
        return when (idBoton) {
            R.id.boton_menu_editar -> {
                Log.d("MENU", "Toca editar")
                val intent = Intent(this, EditarActivity::class.java)
                intent.putExtra(NUMERO_CONS, idConsola) //el personaje que tiene que editar
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}