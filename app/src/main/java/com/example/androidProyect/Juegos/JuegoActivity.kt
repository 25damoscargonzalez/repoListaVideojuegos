package com.example.androidProyect.Juegos

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
        val opcionesPC = listOf(R.drawable.piedra, R.drawable.papel, R.drawable.tijeras)
        val resultadoTxt = findViewById<TextView>(R.id.Resultado);

        imagenJugador.setImageResource(R.drawable.piedra);
        imagenPC.setImageResource(R.drawable.piedra);

            botonPiedra.setOnClickListener {
                val eleccionJugador = R.drawable.piedra;
                imagenJugador.setImageResource(eleccionJugador);

                val eleccionPC = opcionesPC.random();
                imagenPC.setImageResource(eleccionPC);

                //Gana
                if (eleccionJugador == R.drawable.piedra && eleccionPC == R.drawable.tijeras){
                    resultadoTxt.setText("Ganaste")
                }

                //Empate
                if (eleccionJugador == R.drawable.piedra && eleccionPC == R.drawable.piedra){
                    resultadoTxt.setText("Empate")
                }

                //Pierde
                if (eleccionJugador == R.drawable.piedra && eleccionPC == R.drawable.papel){
                    resultadoTxt.setText("Perdiste")
                }
            }

            botonPapel.setOnClickListener {
                val eleccionJugador = R.drawable.papel;
                imagenJugador.setImageResource(eleccionJugador);

                val eleccionPC = opcionesPC.random();
                imagenPC.setImageResource(eleccionPC);

                //Gana
                if (eleccionJugador == R.drawable.papel && eleccionPC == R.drawable.piedra){
                    resultadoTxt.setText("Ganaste")
                }

                //Empate
                if (eleccionJugador == R.drawable.papel && eleccionPC == R.drawable.papel){
                    resultadoTxt.setText("Empate")
                }

                //Pierde
                if (eleccionJugador == R.drawable.papel && eleccionPC == R.drawable.tijeras){
                    resultadoTxt.setText("Perdiste")
                }
            }

            botonTijera.setOnClickListener {
                val eleccionJugador = R.drawable.tijeras;
                imagenJugador.setImageResource(eleccionJugador);

                val eleccionPC = opcionesPC.random();
                imagenPC.setImageResource(eleccionPC);

                //Gana
                if (eleccionJugador == R.drawable.tijeras && eleccionPC == R.drawable.papel){
                    resultadoTxt.setText("Ganaste")
                }

                //Empate
                if (eleccionJugador == R.drawable.tijeras && eleccionPC == R.drawable.tijeras){
                    resultadoTxt.setText("Empate")
                }

                //Pierde
                if (eleccionJugador == R.drawable.tijeras && eleccionPC == R.drawable.piedra){
                    resultadoTxt.setText("Perdiste")
                }
            }
    }
}
