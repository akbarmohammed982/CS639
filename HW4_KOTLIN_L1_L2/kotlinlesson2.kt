package HW4_KOTLIN_L1_L2

//1. Exploring main function

//1.1 main function
fun main(args: Array<String>) {
    println("Hello, world!")
}

//1.2 Pass arguments to main()
fun main(args: Array<String>) {
    println("Hello, ${args[0]}")
}



//2. Learn why (almost) everything has a value

//2.1 Will assign kotlin.Unit
fun main () {
    val isUnit = println("This is an expression")
    println(isUnit)
}

//2.2 Declaring value
fun main(){
    val temperature = 10
    val isHot = if (temperature > 50) true else false
    println(isHot)
}

//2.3 the value of an expression in a string template
fun main(){
    val temperature = 10
    val message = "The water temperature is ${ if (temperature > 50) "too warm" else "OK" }."
    println(message)
}

//3. Learn more about functions
import java.util.*    // required import
//3.1 Create some functions
fun feedTheFish() {
    val day = randomDay()
    val food = "pellets"
    println ("Today is $day and the fish eat $food")
}

fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun main(args: Array<String>) {
    feedTheFish()
}

//3.2 Use a when expression
fun randomDay() : String {
    val week = arrayOf ("Monday", "Tuesday", "Wednesday", "Thursday",
        "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun fishFood (day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "nothing"
    }
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println ("Today is $day and the fish eat $food")
}

fun main(args: Array<String>) {
    feedTheFish()
}

//4. Explore default values and compact functions

//4.1 Create a default value for a parameter
fun swim(speed: String = "fast") {
    println("swimming $speed")
}

fun main() {
    swim() // uses default speed
    swim("slow") // positional argument
    swim(speed = "turtle-like") // named parameter
}*/

//4.2 Add required parameters
import kotlin.random.Random

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }
}

fun randomDay(): String {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return daysOfWeek[Random.nextInt(0, 7)]
}

fun fishFood(day: String): String {
    // Placeholder function for determining fish food based on the day
    return "some food"
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun main() {
    feedTheFish()
}

//4.3 Make compact functions

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun randomDay(): String {
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return daysOfWeek[Random.nextInt(0, 7)]
}

fun fishFood(day: String): String {
    // Placeholder function for determining fish food based on the day
    return "some food"
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun main() {
    feedTheFish()
}

//5. Get started with filters
//5.1 Create a filter
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

fun main() {
    println(decorations.filter { it.first() == 'p' })
}

//5.2 Compare eager and lazy filters
fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Eager, creates a new list
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    // Lazy, will wait until asked to evaluate
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // Force evaluation of the lazy list
    val newList = filtered.toList()
    println("new list: $newList")
}

//5.3 sequence and lazy evaluation working
fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Transformation using map() with a sequence
    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }

    // Print lazyMap
    println("lazy: $lazyMap")

    println("-----")

    // Print the first element of lazyMap
    println("first: ${lazyMap.first()}")

    println("-----")

    // Print lazyMap converted to a List
    println("all: ${lazyMap.toList()}")
}

//5.4 Lazy Evaluation with Filter and Map
fun main() {
    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // Create a sequence using filter and then apply map
    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }

    // Print the filtered result after map
    println("-----")
    println("filtered: ${lazyMap2.toList()}")
}

//5.5 usage of flatten
fun main() {
    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists

    println("-----")
    println("Flat: ${mylist.flatten()}")
}

//6. lambdas and higher-order functions
//6.1 about lambdas
fun main() {
    var dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))
}

//6.2 function variable
fun main() {
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }

    val dirtyLevel = 20
    val filteredWater = waterFilter(dirtyLevel)

    println("Original dirty level: $dirtyLevel")
    println("Filtered dirty level: $filteredWater")
}

//6.3 higher-order function
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun main() {
    val waterFilter: (Int) -> Int = { dirty -> dirty / 2 }
    println(updateDirty(30, waterFilter)) // Output: 15
}

//6.4 passing a regular named function to updateDirty()
fun increaseDirty(start: Int) = start + 1

fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun main() {
    println(updateDirty(15, ::increaseDirty)) // Output: 16
}

//6.5 Updating Dirty Level
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}

fun main() {
    var dirtyLevel = 19
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23 }
    println(dirtyLevel) // Output: 42
}













