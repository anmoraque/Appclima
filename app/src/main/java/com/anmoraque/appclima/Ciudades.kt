package com.anmoraque.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

/*
En esta app hemos creado dos vistas y vimos:
    Navegacion entre actividades
    Uso de Intents (mandar informacion entre vistas)
    Personalizacion de elementos en las vistas
    Manejo de objetos
 */
class Ciudades : AppCompatActivity() {

    //Creamos una constante TAG "la llamamos como nuestro paquete
    //mas la actividad donde está y el valor de la constante (CIUDAD)
    //ES UNA RECOMENDACION DE ANDROID
    //Lo utilizamos para nuestro intent porque necesita un String (clave/valor)
    val TAG = "com.anmoraque.appclima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        //Creamos el valor y hacemos referencia a su vista
        // Entre <> Ponemos el tipo de vista () Ponemos su id de vista
        val bJerez = findViewById<Button>(R.id.bJerez)
        val bSevilla = findViewById<Button>(R.id.bSevilla)
        val bPuerto = findViewById<Button>(R.id.bPuerto)
        val bTarifa = findViewById<Button>(R.id.bTarifa)
        //Añado el listener al button
        bJerez.setOnClickListener(View.OnClickListener {
            //Creamos un intent que nos lleva a la otra actividad (MainActivity)
            //Con el id de la ciudad porque la api nos lo pide
            //IDS Jerez 2516326 Sevilla 2510911 Puerto 2518207 Tarifa 2510599
            val intent = Intent(this, MainActivity::class.java)
            //Mandamos en el intent un String con datos (En este caso el id de la ciudad pulsada)
            intent.putExtra(TAG, "2516326")
            //Iniciamos el intent
            startActivity(intent)

        })
        //Añado el listener al button
        bSevilla.setOnClickListener(View.OnClickListener {
            //Creamos un intent que nos lleva a la otra actividad (MainActivity)
            //Con el id de la ciudad porque la api nos lo pide
            //IDS Jerez 2516326 Sevilla 2510911 Puerto 2518207 Tarifa 2510599
            val intent = Intent(this, MainActivity::class.java)
            //Mandamos en el intent un String con datos (En este caso el id de la ciudad pulsada)
            intent.putExtra(TAG, "2510911")
            //Iniciamos el intent
            startActivity(intent)

        })
        //Añado el listener al button
        bPuerto.setOnClickListener(View.OnClickListener {
            //Creamos un intent que nos lleva a la otra actividad (MainActivity)
            //Con el id de la ciudad porque la api nos lo pide
            //IDS Jerez 2516326 Sevilla 2510911 Puerto 2518207 Tarifa 2510599
            val intent = Intent(this, MainActivity::class.java)
            //Mandamos en el intent un String con datos (En este caso el id de la ciudad pulsada)
            intent.putExtra(TAG, "2518207")
            //Iniciamos el intent
            startActivity(intent)

        })
        //Añado el listener al button
        bTarifa.setOnClickListener(View.OnClickListener {
            //Creamos un intent que nos lleva a la otra actividad (MainActivity)
            //Con el id de la ciudad porque la api nos lo pide
            //IDS Jerez 2516326 Sevilla 2510911 Puerto 2518207 Tarifa 2510599
            val intent = Intent(this, MainActivity::class.java)
            //Mandamos en el intent un String con datos (En este caso el id de la ciudad pulsada)
            intent.putExtra(TAG, "2510599")
            //Iniciamos el intent
            startActivity(intent)

        })
    }
}