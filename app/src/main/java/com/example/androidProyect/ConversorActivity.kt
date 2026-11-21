package com.example.androidProyect

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidProyect.conversor.ConversorKt
import java.util.Locale

class ConversorActivity : AppCompatActivity() {

    private val conversor = ConversorKt()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)

        val spOrigen = findViewById<Spinner>(R.id.primeraDivisa)
        val spDestino = findViewById<Spinner>(R.id.segundaDivisa)
        val txtCantidad = findViewById<EditText>(R.id.txtPrimerNum)
        val txtResultado = findViewById<TextView>(R.id.txtSegundoNum)
        val btnConvertir = findViewById<Button>(R.id.btnConvertir)

        val cardResultado = findViewById<View>(R.id.cardResultado)
        val txtResultadoFinal = findViewById<TextView>(R.id.txtResultadoFinal)
        val txtTasa = findViewById<TextView>(R.id.txtTasa)

        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            conversor.divisas
        )
        spOrigen.adapter = adaptador
        spDestino.adapter = adaptador
        spDestino.setSelection(1) // para que no empiecen las dos iguales

        btnConvertir.setOnClickListener {
            val cantidad = txtCantidad.text.toString().replace(',', '.').toDoubleOrNull()
            if (cantidad == null) {
                txtCantidad.error = "Introduce una cantidad válida"
                return@setOnClickListener
            }

            val origen = spOrigen.selectedItem.toString()
            val destino = spDestino.selectedItem.toString()

            val resultado = conversor.convertir(cantidad, origen, destino)
            val tasa = conversor.convertir(1.0, origen, destino)

            txtResultado.text = "%.2f".format(resultado)

            txtResultadoFinal.text = "%.2f $origen = %.2f $destino".format(cantidad, resultado)

            txtTasa.text = "1 $origen = %.4f $destino".format(tasa)

            cardResultado.visibility = View.VISIBLE
        }
    }
}