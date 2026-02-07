package corparation

abstract class Employee(
    val name: String,
    val age: Int = 0,
    val id: Int
) {
    abstract fun working()
    open fun getInfo(){
        print("ID: $id  Name: $name  Age: $age  ")
    }
}