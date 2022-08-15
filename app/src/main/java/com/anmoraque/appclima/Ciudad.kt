package com.anmoraque.appclima


//Las clases se nombran con la primera mayusculas y en () los atributos
class Ciudad (name:String, weather:ArrayList<Weather>, main:Main){
    //Creamos las variables igual que en la API pues sino no funciona
    //name es un String
    var name:String = ""
    //weather un ArrayList que creo en otra clase
    var weather:ArrayList<Weather>? = null
    //main un objeto que creo en otra clase
    var main:Main? = null
    //Inicializamos los atributos
    init {
        this.name = name
        this.weather = weather
        this.main = main
    }

}