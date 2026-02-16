package corparation

abstract class Employee(
    val name: String,
    val age: Int = 0,
    val id: Int
) {
    abstract fun working()
    abstract fun copy(age: Int = this.age): Employee
    open fun getInfo(){
        print("ID: $id  Name: $name  Age: $age  ")
    }
}