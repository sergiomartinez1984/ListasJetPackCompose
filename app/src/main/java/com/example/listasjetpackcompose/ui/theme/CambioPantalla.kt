package com.example.listasjetpackcompose.ui.theme

sealed class CambioPantalla(
    val ruta:String
) {
    object Pantalla1 : CambioPantalla("Pantalla1")
    object Pantalla2 : CambioPantalla("Pantalla2/{nombre}") {

        fun crearRuta(nombre: String) = "Pantalla2/$nombre"
    }
}
