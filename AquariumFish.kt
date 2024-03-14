package example.myapp

//6 Compare Abstract classes and interfaces

//6.1 Create an abstract class
abstract class AquariumFish {
    abstract val color: String
}

class Shark : AquariumFish() {
    override val color = "grey"
}

class Plecostomus : AquariumFish() {
    override val color = "gold"
}

fun main() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark color: ${shark.color}")
    println("Plecostomus color: ${pleco.color}")
}


//6.2 Create an interface
// AquariumFish.kt

interface FishAction {
    fun eat()
}

abstract class AquariumFish {
    abstract val color: String
}

class Shark : AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus : AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

fun main() {
    val shark = Shark()
    val pleco = Plecostomus()

    println("Shark color: ${shark.color}")
    shark.eat()

    println("Plecostomus color: ${pleco.color}")
    pleco.eat()
}



//6.3 use abstract classes versus interfaces
abstract class AquariumFish {
    abstract val color: String
}

interface FishAction  {
    fun eat()
}

class Shark: AquariumFish(), FishAction {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus: AquariumFish(), FishAction {
    override val color = "gold"
    override fun eat() {
        println("eat algae")
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    makeFish()
}

//7 Use interface delegation

interface FishAction {
    fun eat()
}

interface FishColor {
    val color: String
}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

object GoldColor : FishColor {
    override val color = "gold"
}

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}


fun main() {
    val pleco = Plecostomus()
    val shark = Shark()

    println("Plecostomus color: ${pleco.color}")
    println("Plecostomus action:")
    pleco.eat()

    println("Shark color: ${shark.color}")
    println("Shark action:")
    shark.eat()
}

