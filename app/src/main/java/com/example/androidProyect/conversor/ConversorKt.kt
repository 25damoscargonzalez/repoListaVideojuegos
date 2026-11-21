package com.example.androidProyect.conversor

class ConversorKt {

    private val tasasPorEuro = mapOf(
        "EUR (euros)" to 1.0,
        "USD (dolares)" to 1.0968,
        "ARS (pesos argentinos)" to 1719.698
    )

    val divisas: List<String>
        get() = tasasPorEuro.keys.toList()

    fun convertir(cantidad: Double, origen: String, destino: String): Double {
        val tasaOrigen = tasasPorEuro[origen]
            ?: throw IllegalArgumentException("Divisa desconocida: $origen")
        val tasaDestino = tasasPorEuro[destino]
            ?: throw IllegalArgumentException("Divisa desconocida: $destino")

        val enEuros = cantidad / tasaOrigen
        return enEuros * tasaDestino
    }
}