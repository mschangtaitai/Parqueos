package items

import map.*
class Car (
    private val name : String = "@",
    private val ID : String,
    private val space : Space
){
    fun getID(): String{
        return ID;
    }

    fun getSpace(): Space{
        return space;
    }

    fun getName(): String{
        return name;
    }
}
