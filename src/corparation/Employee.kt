package corparation

open class Employee(
    val name: String,
    val age: Int = 0,
    val id: Int
) {
    open fun working(){
        println("Employee $name is working...")
    }
    open fun getInfo(){
        print("ID: $id  Name: $name  Age: $age  ")
    }
}