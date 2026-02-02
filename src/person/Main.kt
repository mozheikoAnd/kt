package person

fun main() {
    val john = Person(name = "John", age = 18, height = 178, weight = 71.3)
//    john.name = "John"
//    john.age = 18
//    john.height = 178
//    john.weight = 71.3

    john.info()
    john.sayHello()
}