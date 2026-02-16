package corparation

import kotlin.random.Random

class Consultant(
    name: String,
    age: Int = 0,
    id: Int
) : Employee(name, age, id), Cleaner {
    override fun clean() {
        println("Consultant is cleaning.")
    }

    override fun copy(age: Int): Consultant {
        return Consultant(this.name, age, this.id)
    }

    fun sayHello() {
        print("Hello! My name is $name.")
        if (age != 0) print(" My age is $age")
        println("")
    }

    fun observe(): Int {
        val customers = Random.nextInt(1, 100)
        repeat(customers) {
            println("Client was observed...")
        }
        return customers
    }

    override fun working() {
        println("Employee $name is serve...")
    }

    override fun getInfo() {
        super.getInfo()
        println("Position: ${PositionJob.CONSULTANT.title}")
    }
}
