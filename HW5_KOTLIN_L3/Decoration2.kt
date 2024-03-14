//1. Create a Companion Object
class Choice {
    companion object {
        var name: String = "lyric"
        fun showDescription(name:String) = println("My favorite $name")
    }
}

fun main() {
    println(Choice.name)
    Choice.showDescription("pick")
    Choice.showDescription("selection")
}

//2. pairs and triples
//2.1 Make some pairs and triples
fun main() {
    // Create a pair
    val equipment = "fish net" to "catching fish"
    println("${equipment.first} used for ${equipment.second}")

    // Create a triple
    val numbers = Triple(6, 9, 42)
    println(numbers.toString())
    println(numbers.toList())

    // Create a pair where the first part is itself a pair
    val equipment2 = ("fish net" to "catching fish") to "equipment"
    println("${equipment2.first} is ${equipment2.second}")
    println("${equipment2.first.second}")
}

//2.2 Destructure some pairs and triples
fun main() {
    // Destructure a pair and print the values
    val equipment = "fish net" to "catching fish"
    val (tool, use) = equipment
    println("$tool is used for $use")

    // Destructure a triple and print the values
    val numbers = Triple(6, 9, 42)
    val (n1, n2, n3) = numbers
    println("$n1 $n2 $n3")
}

//3. collections
//3.1 Understand more about lists
// Create a list of numbers and sum them up
fun main() {
    // Create a list of numbers and sum them up
    val list = listOf(1, 5, 3, 4)
    println(list.sum()) // Output: 13

    // Create a list of strings and sum the lengths of strings
    val list2 = listOf("a", "bbb", "cc")
    println(list2.sumBy { it.length }) // Output: 6

    // Iterate through the list using listIterator() and print elements separated by spaces
    val list3 = listOf("a", "bbb", "cc")
    for (s in list3.listIterator()) {
        print("$s ") // Output: a bbb cc
    }
    println() // Print a newline
}

//3.2 Hash Maps
fun main() {
    // Create a hash map of fish names and their scientific names
    val scientific = hashMapOf(
        "guppy" to "poecilia reticulata",
        "catfish" to "corydoras",
        "zebra fish" to "danio rerio"
    )

    // Retrieve scientific name based on common fish name key using get()
    println(scientific.get("guppy")) // Output: poecilia reticulata
    println(scientific["zebra fish"]) // Output: danio rerio

    // Try specifying a fish name that isn't in the map
    println(scientific.get("swordtail")) // Output: null

    // Use getOrDefault() to specify a default value for keys not in the map
    println(scientific.getOrDefault("swordtail", "sorry, I don't know")) // Output: sorry, I don't know

    // Use getOrElse() for more complex default value calculations
    println(scientific.getOrElse("swordtail") { "sorry, I don't know" }) // Output: sorry, I don't know
}

//4. Organize and define constants
// Step 1: Top-level constant using const val
const val rocks = 3

// Trying to assign value to const val from a function is not allowed
// const val CONSTANT1 = complexFunctionCall() // NOT ok

// Step 2: Define constants inside a class using companion object
class MyClass {
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}

// Usage of constants
fun main() {
    // Using top-level constant
    println(rocks) // Output: 3

    // Using constant from companion object
    println(MyClass.CONSTANT3) // Output: constant in companion
}

//5. extension functions
//5.1  Write an extension function
// Define the extension function for the String class
fun String.hasSpaces(): Boolean = indexOf(" ") != -1
fun main() {
    val stringWithSpaces = "Hello World"
    val stringWithoutSpaces = "HelloWorld"

    println(stringWithSpaces.hasSpaces()) // Output: true
    println(stringWithoutSpaces.hasSpaces()) // Output: false
}

//5.2  limitations of extensions
open class AquariumPlant(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int) : AquariumPlant("green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun main() {
    val plant = GreenLeafyPlant(size = 10)
    plant.print() // Output: GreenLeafyPlant
    println("\n")
    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() // Output: AquariumPlant
}

//5.3 Add an extension property
class AquariumPlant(val color: String)

val AquariumPlant.isGreen: Boolean
    get() = color == "green"
fun main() {
    val aquariumPlant = AquariumPlant("green")
    println(aquariumPlant.isGreen) // Output: true
}

//5.4 Know about nullable receivers
class AquariumPlant(val color: String) {
    override fun toString(): String {
        return "AquariumPlant(color=$color)"
    }
}

// Define the extension function with a nullable receiver
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

fun main() {
    // Create a nullable instance of AquariumPlant
    val plant: AquariumPlant? = null

    // Call the extension function on the nullable receiver
    plant.pull()
}







