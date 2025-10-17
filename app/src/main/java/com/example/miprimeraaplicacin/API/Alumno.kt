package com.example.miprimeraaplicacin.API

/**
 * Objeto que conecta la aplicacion con el webservices
 * usa corutinas para que las llamadas se ejecuten en segundo plano asi
 * no bloquea el hilo principal
 */


data class Alumno(
    val id: Int,
    val nombre: String,
    val apellido: String,
    val grupo: String,
    val seccion: String
)

/**
 * Esta es una clase de java en donde se utilizan las mismas variables del API para que funcione.
 */
