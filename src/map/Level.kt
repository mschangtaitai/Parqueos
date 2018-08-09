package map


import map.Space
import items.*
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

class Level (
    private val name : String,
    private val path : String
    )
{
    private val height : Int
    private val width : Int
    private val car : ArrayList<Car> = ArrayList()
    private val spaces : ArrayList<Space> = ArrayList()
    private val walls : ArrayList<Wall> = ArrayList()
    init {
        val inputLevel = ArrayList<Array<String>>()
        try {
            val scan = Scanner(File(path))
            while (scan.hasNextLine()) {
                val line = scan.nextLine()
                inputLevel.add(line.trim { it <= ' ' }.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            }
        } catch (ex: FileNotFoundException) {

        }
        this.width = inputLevel.get(0).size
        this.height= inputLevel.size

        for (row in 0 until getHeight()) {
            for (col in 0 until getWidth()) {
                val toEvaluate = inputLevel.get(row)[col]
                when (toEvaluate) {
                    " " -> {
                    }
                    "*" -> {
                        val myWall = Wall(col, row)
                        addWall(myWall)
                    }
                    "@" -> {
                        val space = Space(col, row, toEvaluate, false)
                        addSpace(space)

                    }
                    else -> {
                        val space = Space(col, row, toEvaluate, true)
                        addSpace(space)
                    }
                }
            }
        }
    }

    fun getName(): String {
        return name
    }

    fun getWidth(): Int {
        return width
    }

    fun getHeight(): Int {
        return height
    }

    fun getCars(): ArrayList<Car> {
        return this.car
    }

    fun hasCar(car: Car): Boolean {
        if (this.car.contains(car)){
            return true
        }
        return false
    }

    fun getSpace(x: Int, y: Int): Space? {
        for (space in this.spaces) {
            if (space.getRow() === x && space.getColumn() === y) {
                return space
            }
        }

        return null
    }

    fun addCar(car: Car) {
        this.car.add(car)
    }

    fun getSpaces():ArrayList<Space> {
        return spaces
    }

    fun addWall(wall: Wall){
        this.walls.add(wall)
    }

    fun addSpace(space: Space){
        this.spaces.add(space)
    }

    fun isWall(x: Int,y: Int): Boolean {
        for (wall in this.walls) {
            if (wall.row === x && wall.column === y) {
                return true
            }
        }
        return false
    }

    fun isSpace(x: Int,y: Int): Boolean {
        for (space in this.spaces) {
            if (space.getRow() === x && space.getColumn() === y) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        var result = ""
        for (row in 0 until this.height) {
            for (col in 0 until this.width) {
                if (isWall(col, row)) {
                    result += "*"
                } else if (isSpace(col, row)) {
                    val space = getSpace(col, row)
                    result += space
                } else {
                    result += " "
                }
            }
            result += "\n"
        }

        return result
    }
}