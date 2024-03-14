package example.myapp


//3. Add class constructors

//3.1 Create a constructor
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {

    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
    }

}

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()
    // default height and length
    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()
    // default width
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    // everything custom
    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}

fun main() {
    buildAquarium()
}

//3.2 Add init blocks

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }


    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
    }
}

fun buildAquarium() {
    val aquarium1 = Aquarium()
    aquarium1.printSize()

    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()

    val aquarium4 = Aquarium(width = 25, height = 35, length = 110)
    aquarium4.printSize()
}

fun main() {
    buildAquarium()
}

//3.3 Learn about secondary constructors

class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }

    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} liters")
    }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
    }
}

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
    println("Volume: ${aquarium6.width * aquarium6.length * aquarium6.height / 1000} liters")
}

fun main() {
    buildAquarium()
}

//3.4 Add a new property getter
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }

    val volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 liter

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
        println("Volume: $volume liters")
    }
}

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}

//3.5 Add a property setter
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    init {
        println("aquarium initializing")
    }

    var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    constructor(numberOfFish: Int) : this() {
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1
        // calculate the height needed
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm Length: $length cm Height: $height cm")
        println("Volume: $volume liters")
    }
}

fun buildAquarium() {
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()

    aquarium6.volume = 70
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}


//4 Class with different visibility modifiers
class Aquarium(var width: Int = 20, var height: Int = 40, var length: Int = 100) {
    var volume: Int = 0
        get() = field
        private set(value) {
            field = value
            height = (value * 1000) / (width * length)
        }

    init {
        println("Aquarium initializing")
        volume = width * height * length / 1000
        println("Volume: $volume liters")
    }

    fun printSize() {
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        println("Volume: $volume liters")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium()
    myAquarium.printSize()
}

fun main() {
    buildAquarium()
}

//5 about subclasses and inheritance
//5.1 Make the Aquarium class open
import kotlin.math.PI

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open val shape = "rectangle"

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water: Double = 0.0
        get() = volume * 0.9

    open fun printSize() {
        println(shape)
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        println("Volume: $volume liters, Water: $water liters (${water / volume * 100.0}% full)")
    }
}

fun buildAquarium() {
    val aquarium6 = Aquarium(length = 25, width = 25, height = 40)
    aquarium6.printSize()
}

fun main() {
    buildAquarium()
}

//5.2
import kotlin.math.PI

open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open val shape = "rectangle"

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var water: Double = 0.0
        get() = volume * 0.9

    open fun printSize() {
        println("aquarium initializing")
        println(shape)
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        println("Volume: $volume liters, Water: $water liters (${water / volume * 100.0}% full)")
    }
}

class TowerTank(var diameter: Int, height: Int) : Aquarium(height, diameter, diameter) {
    override val shape = "cylinder"

    override var volume: Int
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8

    override fun printSize() {
        println("aquarium initializing")
        println(shape)
        println("Width: $width cm, Length: $length cm, Height: $height cm")
        println("Volume: $volume liters, Water: $water liters (${water / volume * 100.0}% full)")
    }
}

fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 45)
    myTower.printSize()
}

fun main() {
    buildAquarium()
}
















