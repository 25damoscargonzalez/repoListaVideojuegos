package com.example.androidProyect.conversor

enum class Divisa(val nombre: String, val tasaPorEuro: Double) {
    EUR("EUR (euros)", 1.0),
    USD("USD (dolares)", 1.0968),
    ARS("ARS (pesos argentinos)", 1719.698);

    // Lo que se mostrará en el spinner
    override fun toString(): String = nombre
}

class ConversorKt {

    fun convertir(cantidad: Double, origen: Divisa, destino: Divisa): Double {
        val enEuros = cantidad / origen.tasaPorEuro
        return enEuros * destino.tasaPorEuro
    }
}