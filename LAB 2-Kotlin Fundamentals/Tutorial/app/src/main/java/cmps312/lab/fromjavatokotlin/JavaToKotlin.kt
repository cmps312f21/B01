package cmps312.lab.fromjavatokotlin

/*  Print and variables
    println("Hello")
    print("Hello")

    //Variable declarations
    //final String var1 = "Something"
    //type inference
    val var1 = "Something"

    println(var1)

    var x = 10
    x += 20

    println(x)

    //always declare your variables as val
 */

/*
    val name = "Mohanad"
    var age = 10
    var gender = "Male"

    //String interpolation

    println("Name = $name Age = $age Gender = $gender")
    println("Name = $name Age = $age Gender = $gender Status = ${if (age > 18) "adult" else "Child"}")

//    System.out.printf("Name = %s Age = %d Gender = %s" , name , age , gender)
//    System.out.printf("Name = " + name + " Age = " + age)

//    Null

    val lastname: String? = null

    if (lastname != null) {
        println("The length of the name is ${lastname.length}")
    }

    println("The length of the name is ${lastname?.length}")

    println(
        """
        Name : $name
        Age : $age
        Gender : $gender
    """.trimIndent()
    )

    //instanceof
//    if(name instanceof String){
//
//    }

    //is a relation
    if (name is String)
        println("Yes the name is a string")

    // && and , || or

//    var allowed = age > 18 ? "yes" : "no"

    var allowed = if (age > 18) "yes" else "no"

    age = 10

//    if (age < 13)
//        println("child")
//    else if ((age < 21) and (age > 13))
//        println("Teenager")
//    else
//        println("You are old")


    //when replacement for the switch case
    //score 6..10 excelelnt
    // 6 good
    // bad

    age = 18
    when(age){
        10,11,44,5,6,6,7 -> println("you are either 10 or 11")
        in 14..21-> println("teenager")
        18-> println("you are 18")
        else -> println("old")
    }

 */

/*
 //the new grammar

    for (i in 10 downTo 1)
        print("$i-")

    println()

    for (i in 1 until 10)
        print("$i-")

    println()
    for (i in 1..10)
        print("$i-")
    //functions
    println()

    for (i in 1..10 step 2)
        print("$i-")
    //collections + lamdas

    var i = 0
    while (i < 10) {
        println("This is a while loop similar to java")
        i++
    }
    //collection

    //mutable and immutable

    var numbers = listOf(1, 2, 3, 4, 5)
    println(numbers[0])

    numbers = listOf(44, 55, 6, 7, 4, 2, 322, 2)
    val numbers2 = mutableListOf<Any>(1, "55", 2, "what is your name", 3, 4, 5, 6)
    println(numbers2)

    //display - higher order function , lambdas

    println(sum2(33, 44))
    print(lettergrade(80))

}

fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun largest(a: Int, b: Int) = if (a > b) a else b

fun lettergrade(score: Int) = when (score) {
    in 0..60 -> "F"
    in 60..69 -> "D"
    in 70..79 -> "C"
    else -> "A"
}
 */