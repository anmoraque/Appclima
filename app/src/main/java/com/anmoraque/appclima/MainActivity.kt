package com.anmoraque.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.lang.Exception

/*
En esta app hemos creado dos vistas y vimos:
    Navegacion entre actividades
    Uso de Intents (mandar informacion entre vistas)
    Personalizacion de elementos en las vistas
    Manejo de objetos
 */
class MainActivity : AppCompatActivity() {
    //Creamos las variables de nuestros TextViews
    //Lo ponemos opcional (?) para poder inicializarlo a null (nulo)
    var tVCiudad:TextView? = null
    var tVGrados:TextView? = null
    var tVEstatus:TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Referenciamos las variables de arriba para traerlas del Layout
        tVCiudad = findViewById(R.id.tCiudad)
        tVGrados = findViewById(R.id.tGrados)
        tVEstatus = findViewById(R.id.tEstatus)
        //Creamos una variable para recibir los datos del intent "la llamamos al igual
        //que en la otra actividad como nuestro paquete mas la actividad
        // donde está y el valor de la constante (CIUDAD)
        //ES UNA RECOMENDACION DE ANDROID
        //Lo utilizamos para nuestro intent porque necesita un String (clave/valor)
        val ciudad = intent.getStringExtra("com.anmoraque.appclima.ciudades.CIUDAD")

        //Codigo para validar red
        //Network tiene red (Se referencia con this, mi actividad actual)
        //En la class Network era context aqui this
        //Si hay red llamo la funcion solicitudHTTPVolley y si no pongo un toast
        if (Network.hayRed(this)) {
            //Ejecutar Solicitud HTTP
            //Mirar con llamar a los datos en la API usada
            //Clave api openweathermap.org 22693edb295c778af525994599ecf7b8
            //IDS Jerez 2516326 Sevilla 2510911 Puerto 2518207 Tarifa 2510599
            //La api nos pide nuestra key al darnos de alta, el id de cada ciudad
            //Que en este caso viene en el intent (ciudad) y otros parametros para grados celcius y idioma es
            solicitudHTTPVolley("https://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=22693edb295c778af525994599ecf7b8&units=metric&lang=es")


        }else {
            Toast.makeText(this, "Conectese a Internet", Toast.LENGTH_LONG).show()
        }

    }
    //Metodo para solicitar HTTP con volley
    //Voy a pedir una URL
    private fun solicitudHTTPVolley (url:String){
        //Esta libreria funciona a base de colas, es decir
        // administra multiples solicitudes HTTP a la vez
        //Creamos una variable de volley para una nueva solicitud
        val queue = Volley.newRequestQueue(this)
        //Esta variable nos permite construir la solicitud y el
        //resultado lo da en forma de String
        //Nos pide varios parametros (Tipo de solicitud en este caso GET para recibir,
        //una url, un listener de respuesta en este caso tipo String (donde escribo el codigo
        //a realizar con la respuesta) y al final un listener de error
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String> {
            //Aqui viene la respuesta
                response ->
            //Por si algo falla hacemos try catch
            try {
                //¿Que voy hacer con la respuesta?
                Log.d("ETIQUETA_LOG","solicitudHTTPVolley $response")
                //Parseamos la información obtenida a la clase Ciudad
                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)
                //Mandamos la informacion de cada ciudad a nuestros Textview
                tVCiudad?.text = ciudad.name
                //Aqui el double lo paso a String y le agrego "º" para los grados
                tVGrados?.text = ciudad.main?.temp.toString() + "º"
                //Aqui cogemos el Objeto 0 del Array weather (es el único que hay)
                tVEstatus?.text = ciudad.weather?.get(0)?.description
            }catch (e: Exception) {  }
        }, Response.ErrorListener {  })
        //Lo añadimos a la variable que hace la solicitud
        queue.add(solicitud)
    }

}