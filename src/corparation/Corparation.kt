package corparation

fun main() {
//    val accountant = Accountant("Irina", 29, 1)
//    accountant.working()
    val assistant = EmployeeRepository.findAssistant()
    val director = EmployeeRepository.findDirector()
    if (assistant != null) {
        director?.getCoffee(assistant)
    }
}