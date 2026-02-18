package person

class Person(
    val name: String,
    val height: Int,
    val weight: Double,
    val lastName: String
) {
    override fun toString(): String {
        return "Name: $name, Height: $height, Weight: $weight, Last Name: $lastName"
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Person) return false
        return other.name == name && other.height == height && other.weight == weight && other.lastName == lastName
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight.hashCode()
        result = 31 * result + age.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + lastName.hashCode()
        result = 31 * result + fullName.hashCode()
        println("Working hashCode()...")
        return result
    }

    fun copy(
        name: String = this.name,
        height: Int = this.height,
        weight: Double = this.weight,
        lastName: String = this.lastName
    ): Person {
        return Person(name, height, weight, lastName)
    }

    fun setLastName(lastName: String): Person {
        println("Congratulations on the wedding $lastName")
        return copy(lastName = lastName)
    }

    val fullName: String
        get() = "$lastName $name"
    var age: Int = 0
        set(value) {
            if (value < field) {
                println("Wrong age")
            } else {
                field = value
            }
        }
        get() {
            println("Question about age is not comfortable")
            return field
        }

    fun run() {
        repeat(10) {
            println("$name is run $it")
        }
    }

    fun info() {
        println(
            """
    $name
    $age 
    $height
    $weight
    """.trimIndent()
        )
    }

    fun sayHello() {
        println("Hello! My name is $name")
    }
}