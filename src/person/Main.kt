package person

import com.sun.tools.javac.tree.TreeInfo.fullName

fun main() {
    var john = Person(name = "John", height = 178, weight = 71.3, lastName = "Oldam")
    val john2 = Person(name = "John", height = 178, weight = 71.3, lastName = "Oldam")
    val bob = Person(name = "Bob", height = 178, weight = 71.3, lastName = "Oldam")

    val persons = mutableSetOf<Person>()
    persons.add(john)
    persons.add(bob)
    persons.add(john2)

    john = john.setLastName("Petrov")
    println(john)

    for (person in persons) {
        println(person)
        println(person.hashCode())
    }
}