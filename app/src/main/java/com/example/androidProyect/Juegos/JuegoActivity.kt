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
        val botonJugar = findViewById<Button>(R.id.bJugar);
        val opcionesPC = listOf(R.drawable.piedra, R.drawable.papel, R.drawable.tijeras)

        imagenJugador.setImageResource(R.drawable.piedra);
        imagenPC.setImageResource(R.drawable.piedra);

            botonPiedra.setOnClickListener {
                imagenJugador.setImageResource(R.drawable.piedra);
                botonPiedra.isEnabled = false;
                botonPiedra.isOpaque;

                botonPapel.isEnabled = false;
                botonPapel.isOpaque;

                botonTijera.isEnabled = false;
                botonTijera.isOpaque;

            }

            botonPapel.setOnClickListener {
                imagenJugador.setImageResource(R.drawable.papel);
                botonPapel.isEnabled = false;
                botonPapel.isOpaque;

                botonPiedra.isEnabled = false;
                botonPiedra.isOpaque;

                botonTijera.isEnabled = false;
                botonTijera.isOpaque;

            }

            botonTijera.setOnClickListener {
                imagenJugador.setImageResource(R.drawable.tijeras);
                botonTijera.isEnabled = false;
                botonTijera.isOpaque;

                botonPiedra.isEnabled = false;
                botonPiedra.isOpaque;

                botonPapel.isEnabled = false;
                botonPapel.isOpaque;
            }

        botonJugar.setOnClickListener {
            var respuestaPC = opcionesPC.random();
            var imagen = imagenPC.setImageResource(respuestaPC);

            //EL JUGADOR GANA

            if (imagen.equals(R.drawable.piedra) && imagenJugador.equals(R.drawable.papel)){
                //El jugador ha ganado
            }

            if (imagen.equals(R.drawable.papel) && imagenJugador.equals(R.drawable.tijeras)){
                //El jugador ha ganado
            }

            if (imagen.equals(R.drawable.tijeras) && imagenJugador.equals(R.drawable.piedra)){
                //El jugador ha ganado
            }

            //EMPATE

            //PIERDE
        }
    }
}
