package com.example.androidProyect.datos

import com.example.androidProyect.modelo.Consola

class ListaConsolas : RepositorioConsolas{
    private val lista: MutableList<Consola> = mutableListOf() //Mas o menos es lo mismo que el ArrayList

    override fun nuevaConsola(p: Consola) { //Aqui al sobreescribir un metodo (override) TE OBLIGA A HACERLO
        lista.add(p)
    }

    override fun actualizar(id: Int, p: Consola) {
        lista[id] = p
    }

    override fun borrar(id: Int) {
        lista.removeAt(id)
    }

    override fun buscar(id: Int): Consola {
        return lista[id]
    }

    override fun longitud(): Int = lista.size //SE PUEDE HACER ASI TAMBIEN EL RETURN
}

