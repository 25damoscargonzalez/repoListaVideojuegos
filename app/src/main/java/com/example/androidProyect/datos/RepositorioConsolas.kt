package com.example.androidProyect.datos

import com.example.androidProyect.R
import com.example.androidProyect.modelo.Consola
import com.example.androidProyect.modelo.Empresa
import java.time.LocalDate

interface RepositorioConsolas {

    fun poblar() {
        nuevaConsola(
            p = Consola("PlayStation5", R.drawable.ps5, 450.90f, LocalDate.of(2020, 11, 12), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("PlayStation4", R.drawable.ps4 , 450.90f, LocalDate.of(2014, 3, 20), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("Xbox360", R.drawable.xbox360 , 450.90f, LocalDate.of(2012, 9, 5), Empresa.Microsoft, "")
        )
        nuevaConsola(
            p = Consola("PlayStation2",R.drawable.ps2 , 450.90f, LocalDate.of(2000, 11, 20), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("Gameboy",R.drawable.gameboy , 433.90f , LocalDate.of(1988, 1, 30), Empresa.Nintendo, "")
        )
    }

    fun nuevaConsola(p: Consola)
    //Fun --> Funciones (Son metodos)
    fun actualizar(id: Int, p: Consola)
    fun borrar(id: Int)
    fun buscar(id: Int): Consola
    fun longitud(): Int
}
