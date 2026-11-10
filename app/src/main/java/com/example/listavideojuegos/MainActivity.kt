package com.example.listavideojuegos

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.listavideojuegos.datos.ListaConsolas

class MainActivity : AppCompatActivity() {

    companion object { //Creamos un bloque y dentro definimos lo que queremos que sea static
        val listaConsolas = ListaConsolas()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        listaConsolas.poblar()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.bCalculadora).setOnClickListener {

        }

        findViewById<Button>(R.id.bConversor).setOnClickListener {

        }

        findViewById<Button>(R.id.bJuegos).setOnClickListener {

        }

        findViewById<Button>(R.id.bLista).setOnClickListener {

        }

        findViewById<Button>(R.id.bIrConsola).setOnClickListener {
            dialogoElegir()
        }

    }

    fun dialogoElegir() {
        val entrada = EditText(this)

        entrada.inputType = InputType.TYPE_CLASS_NUMBER
        entrada.hint = "Número de videojuego"

        AlertDialog.Builder(this) //AlertDialog tiene una subclase que te construye un dialogo de alerta
            .setTitle("Elige un videojuego")
            .setTitle("Introduce un número para elegir el videojuego")
            .setView(entrada) //Todos los elementos se llaman "View"
            .setNegativeButton("Cancelar", null)
            .setPositiveButton("Buscar") { dialog, whichButton -> //diaglog (p0) y whichButton(p1) son parametros vacios
                val num = entrada.text.toString().toInt()

                val intent = Intent(this, VideojuegoActivity::class.java)
                intent.putExtra("numero", num)
                startActivity(intent)
            }
            .show()
    }

}