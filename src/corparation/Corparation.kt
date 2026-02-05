package corparation

fun main() {
    val director = Director("John", 45)
    val assistant = Assistant("Kris")
    val consultant = Consultant("John", 45)
    val employee = Employee("Igor", 38)
    val accountant = Accountant("Irina", 29)

    val workers = listOf<Employee>(director, assistant, consultant, employee, accountant)
    for (worker in workers) {
        worker.working()
    }
}