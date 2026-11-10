package com.example.listavideojuegos.datos

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.listavideojuegos.modelo.Consola
import com.example.listavideojuegos.modelo.Empresa
import java.time.LocalDate

interface RepositorioConsolas {

    fun poblar() {
        nuevaConsola(
            p = Consola("PlayStation5", 450.90f, LocalDate.of(2020, 11, 12), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("PlayStation4", 450.90f, LocalDate.of(2014, 3, 20), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("Xbox360", 450.90f, LocalDate.of(2012, 9, 5), Empresa.Microsoft, "")
        )
        nuevaConsola(
            p = Consola("PlayStation2", 450.90f, LocalDate.of(2000, 11, 20), Empresa.Sony, "")
        )
        nuevaConsola(
            p = Consola("Gameboy", 450.90f, LocalDate.of(1988, 1, 30), Empresa.Nintendo, "")
        )
    }

    fun nuevaConsola(p: Consola)
    //Fun --> Funciones (Son metodos)
    fun actualizar(id: Int, p: Consola)
    fun borrar(id: Int)
    fun buscar(id: Int): Consola
    fun longitud(): Int
}
