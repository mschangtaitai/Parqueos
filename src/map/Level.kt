package map


import map.Space
import items.*
import java.io.File
import java.io.FileNotFoundException
import java.util.*
import kotlin.collections.ArrayList

class Level (
       private val name : String,
       private val width : Int,
       private val height : Int,
       private val car : ArrayList<Car> = ArrayList(),
       private val spaces : ArrayList<Space> = ArrayList(),
       private val walls : ArrayList<Wall> = ArrayList()
){
    fun getName(): String {
        return name
    }

    fun getWidth(): Int {
        return width;
    }

    fun getHeight(): Int {
        return height
    }

    fun getCars(): ArrayList<Car> {
        return car
    }

    fun getSpace(x: Int, y: Int): Space? {
        for (space in this.spaces) {
            if (space.getRow() === x && space.getColumn() === y) {
                return space
            }
        }

        return null
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

    private fun readMap(mapFilePath: String): ArrayList<Array<String>> {
        val inputLevel = ArrayList<Array<String>>()
        try {
            val scan = Scanner(File(mapFilePath))
            while (scan.hasNextLine()) {
                val line = scan.nextLine()
                inputLevel.add(line.trim { it <= ' ' }.split("".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray())
            }
        } catch (ex: FileNotFoundException) {

        }

        return inputLevel
    }

    fun buildLevel(i: String,inputLevel: ArrayList<String>) {
        val level = Level(i, inputLevel.get(0).length, inputLevel.size)

        for (row in 0 until level.getHeight()) {
            for (col in 0 until level.getWidth()) {
                val toEvaluate = inputLevel.get(row)[col]
                when (Character.toString(toEvaluate)) {
                    " " -> {
                    }
                    "*" -> {
                        val myWall = Wall(col, row)
                        level.addWall(myWall)
                    }
                    "@" -> {
                        val space = Space(col, row, Character.toString(toEvaluate), false, level)
                        level.addSpace(space)

                    }
                    else -> {
                        val space = Space(col, row, Character.toString(toEvaluate), true, level)
                        level.addSpace(space)
                    }
                }
            }
        }
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