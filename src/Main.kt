import map.*
import items.Car

fun main(args: Array<String>) {
    var menu1 = """
        Elija una opcion:
        1.) Administrador
        2.) Conductor
        3.) Salir
    """.trimIndent()
    var menu2 = """
        Elija una opcion:
        1.) Crear nivel
        2.) Eliminar nivel
        3.) Ver todos los niveles
        4.) Salir
    """.trimIndent()
    var menu3 = """
        Elija una opcion:
        1.) Parquear carro
        2.) Buscar carro
        3.) Salir
    """.trimIndent()

    var wantsToContinue = true

    val parking = Parking()
    do {
        println(menu1)
        val strOption = readLine()!!
        val option = strOption.toInt()
        when (option){
            1 -> {
                var cicle = true
                do {
                    println(menu2)
                    val strOption = readLine()!!
                    val option = strOption.toInt()
                    when (option){
                        1 -> {
                            println("Nombre para nivel: ")
                            val nameLevel = readLine()!!
                            println("Formato de nivel: ")
                            val levelStyle = readLine()!!
                            val finalLevel = Level(nameLevel,levelStyle)
                            println(finalLevel)
                            parking.addLevel(finalLevel)
                            println("Nivel creado")
                        }

                        2 -> {
                            println("Que nivel desea eliminar? (Ingrese numero) ")
                            var i = 1
                            for (niveles in parking.getLevels()){
                                println(i.toString() + ".) " +niveles.getName())
                                i += 1
                            }
                            try {
                                val deletedLevel = readLine()!!.toInt()
                                if (parking.getLevels().size > deletedLevel) {
                                    parking.deleteLevel(deletedLevel - 1)
                                } else {
                                    println("Ese parqueo no existe...")
                                }
                            }catch(ex: NumberFormatException){
                                println("Ingreso invalido")
                            }
                        }
                        3 -> {
                            println("Todos los niveles: \n")
                            var i = 1
                            for (niveles in parking.getLevels()){
                                println(i.toString() + ".) " +niveles.getName())
                                println(niveles)
                                i += 1
                            }
                        }
                        4 -> {
                            cicle = false
                        }
                    }
                }while (cicle)
            }
            2 -> {
                var cicle = true
                do{
                    println(menu3)
                    val strOption = readLine()!!
                    val option = strOption.toInt()
                    when (option) {
                        1 -> {
                            println("Ingrese las placas de su carro: ")
                            val carID = readLine()!!
                            var car = Car(carID)
                            for (Level in parking.getLevels()) {
                                if (Level.hasCar(car)) {
                                    println("Ese carro ya existe")
                                }else {
                                    println("En que nivel desea parquear su carro?")
                                    var i = 1
                                    for (niveles in parking.getLevels()) {
                                    println(i.toString() + ".) " + niveles.getName())
                                    i += 1
                                    }
                                    val Level = readLine()!!.toInt()
                                    println(parking.getLevels()[Level-1])
                                    println("En que lugar desea parquearse?")
                                    val place = readLine()!!
                                    for (i in parking.getLevels()[Level-1].getSpaces()){
                                        if (i.getName() == place) {
                                            parking.getLevels()[Level-1].addCar(car)
                                            i.park()
                                            i.setCar(car)
                                            println("Se ha parqueado en: " + place)
                                        }else {
                                        }
                                    }
                                }
                            }

                        }
                        2 -> {
                            println("Ingrese su numero de placa")
                            val placa = readLine()!!
                            for (Level in parking.getLevels()) {
                                for (car in Level.getCars()) {
                                    if (placa == car.getID()) {
                                        println("Su carro se encuentra en el nivel " + Level.getName())
                                        println(Level)
                                    }
                                }
                            }
                        }
                        3 -> {
                            cicle = false
                        }
                    }
                }while (cicle)
            }
            3 -> {
                wantsToContinue = false
            }
        }
    }while (wantsToContinue)
}