package person

fun main() {
    val john = Person(name = "John", height = 178, weight = 71.3, lastName =  "Oldam")
//    john.name = "John"
//    john.age = 18
//    john.height = 178
//    john.weight = 71.3

//    john.info()
//    john.run()
//    john.sayHello()
//    john.age = 18
//    println(john.age)
//    john.age = 17
//    println(john.age)
    println(john.fullName)
    john.setLastName("Turikov")
    println(john.fullName)
}