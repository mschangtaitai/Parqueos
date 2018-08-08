package map

import map.*
import items.*

class Parking  (
    private val levels : ArrayList<Level> = ArrayList()
){
    fun getLevels(): ArrayList<Level>{
        return levels;
    }
}