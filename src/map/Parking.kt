package map

import map.*
import items.*

class Parking  (
    private val levels : ArrayList<Level> = ArrayList()
){
    fun getLevels(): ArrayList<Level>{
        return levels
    }

    fun addLevel(level: Level) {
        this.levels.add(level)
    }

    fun deleteLevel(index: Int) {
        this.levels.removeAt(index)
    }
}