package map

import items.*
class Space (
    private val row : Int,
    private val column : Int,
    private val name : String,
    private var available : Boolean = true,
    private var car : Car? = null
){
    fun getName(): String{
        return name;
    }

    fun getRow(): Int{
        return row
    }

    fun getColumn(): Int{
        return column
    }

    fun setCar(car: Car) {
        this.car = car
    }

    fun park(): Boolean{
        available = !available;
        return available;
    }

    override fun toString(): String {
        if (!available){
            return "@"
        }
        return "" + this.name
    }
}