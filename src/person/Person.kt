package person

class Person(
    private val name: String,
    private val height: Int,
    private val weight: Double,
    var lastName: String
){
    fun setLastName(lastName: String){
        println("Congratulations on the wedding $lastName")
        this.lastName = lastName
    }

    val fullName: String
    get() = "$lastName $name"
    var age: Int = 0
    set(value) {
        if (value < field) {
            println("Wrong age")
        }else{
            field = value
        }
    }
        get() {
            println("Question about age is not comfortable")
            return field
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