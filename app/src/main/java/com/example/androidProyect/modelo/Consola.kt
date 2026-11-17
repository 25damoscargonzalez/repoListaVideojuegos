package com.example.androidProyect.modelo

import java.time.LocalDate

class Consola (
    var nombre: String,
    var imagen: Int,
    var almacenamiento: Float,
    var fechaLanzamiento: LocalDate,
    var empresa: Empresa,
    var descripcion: String = "",
    var opinion: Int = 0
){

}