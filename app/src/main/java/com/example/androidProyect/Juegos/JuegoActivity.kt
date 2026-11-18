package com.example.androidProyect.Juegos

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidProyect.R

class JuegoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_juego)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val botonPapel = findViewById<Button>(R.id.bPapel);
        val botonPiedra = findViewById<Button>(R.id.bPiedra);
        val botonTijera = findViewById<Button>(R.id.bTijera);
        var imagenJugador = findViewById<ImageView>(R.id.imagenJugador);
        var imagenPC = findViewById<ImageView>(R.id.imagenPC);

        botonPiedra.setOnClickListener {
            imagenJugador.setImageResource(R.drawable.piedra);
        }

        botonPapel.setOnClickListener {
            imagenJugador.setImageResource(R.drawable.papel);
        }

        botonTijera.setOnClickListener {
            imagenJugador.setImageResource(R.drawable.tijeras);
        }

    }
}
