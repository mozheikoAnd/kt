package files

import java.io.File
//test change
fun main() {
    val file = File("ToDo.txt")
    file.writeText("")
    val operationCodes = OperationCode.entries
    while (true) {
        print("Enter your action. ")
        for ((index,operation) in operationCodes.withIndex()) {
            print("$index - ${operation.title}")
            if (index == operationCodes.lastIndex) print(": ")
            else print(", ")
        }
        val operationIndex = readln().toInt()
        val operation = operationCodes[operationIndex]
        when (operation) {
            OperationCode.EXIT -> break
            OperationCode.ADD_TODO -> addToDo(file)
            OperationCode.SHOW_ALL_TODO -> showAllToDo(file)
        }
    }
}

fun addToDo(file: File) {
    print("Enter your todo: ")
    file.appendText("${readln()}\n")
}

fun showAllToDo(file: File) {
    val allTodo = file.readText().trim().split("\n")
    var counter = 0
   while (counter < allTodo.size) {
       println("$counter - ${allTodo[counter]}")
       counter++
   }
}