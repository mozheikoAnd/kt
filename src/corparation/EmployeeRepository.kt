package corparation

import java.io.File

object EmployeeRepository {

    val fileEmployee = File("workers.txt")
    private val _allEmployees = getEmployees()
    val allEmployees
        get() = _allEmployees.toList()

    private fun getEmployees(): MutableList<Employee> {
        val employeeAll = mutableListOf<Employee>()
        if (fileEmployee.readText().isEmpty()) {
            return employeeAll
        }

        val employeesStr = fileEmployee.readText().trim().split("\n")
        for ((index, employeeStr) in employeesStr.withIndex()) {
            val employeeSplit = employeeStr.split("%")
            val id = employeeSplit[0].toInt()
            val name = employeeSplit[1]
            val age = employeeSplit[2].toInt()
            val position = employeeSplit[employeeSplit.lastIndex]
            val employee = when (PositionJob.valueOf(position)) {
                PositionJob.DIRECTOR -> Director(name, age, id)
                PositionJob.ACCOUNTANT -> Accountant(name, age, id)
                PositionJob.ASSISTANT -> Assistant(name, age, id)
                PositionJob.CONSULTANT -> Consultant(name, age, id)
            }
            employeeAll.add(employee)
        }
        return employeeAll
    }

    fun registerEmployee(employee: Employee) {
        for (worker in _allEmployees) {
            if (worker == employee) return
        }
        _allEmployees.add(employee)
    }

    fun saveEmployee() {
        saveEmployeeToFile()
    }

    private fun saveEmployeeToFile() {
        val content = StringBuilder()
        for (employee in _allEmployees) {
            content.append("${employee.id}%${employee.name}%${employee.age}%")
            content.append(
                when (employee) {
                    is Accountant -> ("${PositionJob.ACCOUNTANT}\n")
                    is Assistant -> ("${PositionJob.ASSISTANT}\n")
                    is Consultant -> ("${PositionJob.CONSULTANT}\n")
                    is Director -> ("${PositionJob.DIRECTOR}\n")
                    else -> ""
                }
            )
        }
        fileEmployee.writeText(content.toString())
    }

    fun fireEmployee(id: Int) {
        for (employee in _allEmployees) {
            if (employee.id == id) {
                _allEmployees.remove(employee)
                break
            }
        }
    }

    fun changeAge(id: Int, age: Int) {
        for ((index, worker) in _allEmployees.withIndex()) {
            if (worker.id == id) {
                val newWorker = worker.copy(age = age)
                _allEmployees[index] = newWorker
            }
        }
    }

    fun findDirector(): Director? {
        for (employee in _allEmployees) {
            if (employee is Director) return employee
        }
        return null
    }

    fun findAssistant(): Assistant? {
        for (employee in _allEmployees) {
            if (employee is Assistant) return employee
        }
        return null
    }
}