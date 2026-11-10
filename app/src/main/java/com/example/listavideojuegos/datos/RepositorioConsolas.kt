package com.example.listavideojuegos.datos

import com.example.listavideojuegos.modelo.Consola
import com.example.listavideojuegos.modelo.Consolas

interface RepositorioConsolas {
    fun poblar() {
        nuevaConsola(
            p = Consola("PlayStation5", "Estudiante 2ºDAM", Consolas.PS5)
        )
        nuevaConsola(
            p = Consola("PlayStation4", "Estudiante 2ºDAM", Consolas.PS4)
        )
        nuevaConsola(
            p = Consola("Xbox360", "Estudiante 2ºDAM", Consolas.XBOX360)
        )
        nuevaConsola(
            p = Consola("PlayStation2", "Estudiante 2ºDAM", Consolas.PS2)
        )
        nuevaConsola(
            p = Consola("Gameboy", "Estudiante 2ºDAM", Consolas.GAMEBOY)
        )
    }

    fun nuevaConsola(p: Consola)
    //Fun --> Funciones (Son metodos)
    fun actualizar(id: Int, p: Consola)
    fun borrar(id: Int)
    fun buscar(id: Int): Consola
    fun longitud(): Int
}
