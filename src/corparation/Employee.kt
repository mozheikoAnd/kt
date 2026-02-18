package corparation

abstract class Employee(
    val name: String,
    val age: Int = 0,
    val id: Int
) {
    abstract fun working()
    abstract fun copy(age: Int = this.age): Employee
    open fun getInfo() {
        print("ID: $id  Name: $name  Age: $age  ")
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Employee) return false
        if (
            this.name == other.name &&
            this.age == other.age &&
            this.id == other.id
        ) return true
        return false
    }
}