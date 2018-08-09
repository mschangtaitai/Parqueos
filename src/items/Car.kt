package items

import map.*
class Car (
    private val ID : String,
    private val name : String = "@"
){
    fun getID(): String{
        return ID;
    }

    fun getName(): String{
        return name;
    }
}
