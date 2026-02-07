package person

class Person(
    private val name: String,
    private val age: Int,
    private val height: Int,
    private val weight: Double
){
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