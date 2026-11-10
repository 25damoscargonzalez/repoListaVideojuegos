package com.example.listavideojuegos.datos

class RepositorioSingleton {
    companion object {
        val instance = RepositorioSingleton()
    }

    //Inicializamos una Lista de personajes y luego la poblamos
    val listaVideojuegos: RepositorioVideojuegos = ListaVideojuegos();

    //Cualquier parte del constructor que no inicializa variables
    init {
        listaVideojuegos.poblar()
    }
}