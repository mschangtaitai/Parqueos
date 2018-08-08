package map


import map.Space
import items.*

class Level (
       private val name : String,
       private val width : Int,
       private val height : Int,
       private val car : ArrayList<Car> = ArrayList(),
       private val spaces : ArrayList<Space> = ArrayList()
){
    fun getName(): String {
        return name;
    }

    fun getWidth(): Int {
        return width;
    }

    fun getHeight(): Int {
        return height;
    }

    fun getCars(): ArrayList<Car> {
        return car;
    }

    fun getSpaces(): ArrayList<Space> {
        return spaces;
    }
}