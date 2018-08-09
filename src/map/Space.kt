package map

class Space (
    private val row : Int,
    private val column : Int,
    private val name : String,
    private var available : Boolean = true,
    private val level : Level
){
    fun getName(): String{
        return name;
    }

    fun isAvaillable(): Boolean{
        return available;
    }

    fun getRow(): Int{
        return row
    }

    fun getColumn(): Int{
        return column
    }

    fun getLevel(): Level{
        return level;
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