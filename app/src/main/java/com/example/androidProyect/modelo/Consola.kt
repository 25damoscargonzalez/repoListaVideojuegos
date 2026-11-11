package com.example.androidProyect.modelo

import java.time.LocalDate

class Consola (
    val nombre: String,
    val imagen: Int,
    val Almacenamiento: Float,
    val FechaLanzamiento: LocalDate,
    val Empresa: Empresa,
    var descripcion: String = "",
    var opinion: Int = 0
){

}