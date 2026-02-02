package corparation

open class Employee(
    val name: String,
    val age: Int = 0
) {
    open fun working(){
        println("Employee $name is working...")
    }
}