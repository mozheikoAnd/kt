package person

class Person {
    val name: String
    val age: Int
    val height: Int
    val weight: Double

    constructor(name : String, age : Int, height : Int, weight : Double) {
        this.name = name
        this.age = age
        this.height = height
        this.weight = weight
    }

    fun run(){
        repeat(10){
            println("$name is run $it")
        }
    }
    fun info(){
        println("""
    $name
    $age 
    $height
    $weight
    """.trimIndent())
    }
    fun sayHello(){
        println("Hello! My name is $name")
    }
}