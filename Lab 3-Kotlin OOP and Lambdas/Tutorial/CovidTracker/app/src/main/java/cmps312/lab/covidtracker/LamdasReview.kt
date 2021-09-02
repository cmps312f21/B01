package cmps312.lab.covidtracker

fun mul(num1: Int, num2: Int): Int {
    return num1 * num2
}

fun mul2(num1: Int, num2: Int) = num1 * num2

val mul3 = { num1: Int, num2: Int -> num1 * num2 }
val add = { num1: Int, num2: Int -> num1 + num2 }
val sub = { num1: Int, num2: Int -> num1 - num2 }
val div = { num1: Int, num2: Int -> num1 / num2 }

//higher order function
fun calculate(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}


fun main() {
//    println(mul(2, 3))
//    println(mul2(2, 3))
//    println(mul3(2, 3))
//    println(calculate(12, 3, mul3))
//    println(calculate(12, 3, add))
//    println(calculate(12, 3, sub))
//    println(calculate(12, 3, div))


    var numbers = listOf(1, 0 , 22, 33, 44, 3, 2, 1, 3)
//    val display = {a: Int -> println(a)}
//    numbers.forEach(display)

    numbers.forEach { a: Int -> println(a) }
    numbers.forEach { println(it) }


    val sum = numbers.sumOf { it }
    val count = numbers.count()
    val zeroExit = numbers.any { it == 1110 }
    val zero = numbers.find { it == 220 }
    val gThan25 = numbers.filter { it > 25 }
    val top5 = numbers.sorted().takeLast(3)


    println("Sum = $sum")
    println("count = $count")
    println("zeroExit = $zeroExit")
    println("zero = $zero")
    println("gThan25 = $gThan25")
    println("top5 = $top5")
}


