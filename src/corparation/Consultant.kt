package corparation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
): Employee(name, age) {
    fun sayHello() {
        print("Hello! My name is $name.")
        if (age != 0) print(" My age is $age")
        println("")
    }
    fun observe (): Int{
        val customers = Random.nextInt(1, 100)
        repeat(customers) {
            println("Client was observed...")
        }
        return customers
    }

    override fun working() {
        println("Employee $name is serve...")
    }
}
