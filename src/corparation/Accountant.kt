package corparation

import java.io.File

class Accountant(
    name: String,
    age: Int,
    id: Int
) : Employee(name, age, id) {

    val file = File("product_card.txt")
    val fileEmployee = File("workers.txt")

    override fun getInfo() {
        super.getInfo()
        println("Position: ${PositionJob.ACCOUNTANT.title}")
    }

    override fun working() {
        while (true) {
            val operations = Operation.entries
            var operationIndex: Int
            while (true) {
                println("Enter your operation. ")
                for ((index, oper) in operations.withIndex()) {
                    println("$index - ${oper.title}")

                }
                operationIndex = readln().toInt()
                if (operationIndex in 0..operations.lastIndex) {
                    break
                } else println("Wrong operation. Try again.")
            }
            val operation = operations[operationIndex]
            when (operation) {
                Operation.EXIT -> break
                Operation.ADD_CARD -> addCard()
                Operation.SHOW_ALL_CARDS -> showAllItems()
                Operation.DELETE_CARD -> deleteCard()
                Operation.REGISTER_EMPLOYEE -> registerEmployee()
                Operation.FIRE_EMPLOYEE -> fireEmployee()
                Operation.SHOW_ALL_EMPLOYEE -> showAllEmployees()
            }
        }
    }


    fun deleteCard() {
        print("Enter name of card which you want to delete: ")
        val nameCard = readln()
        val cards = loadAllCards()
        file.writeText("")
        for (card in cards) {
            if (card.naming != nameCard) {
                saveProductCardToFile(card)
            }
        }
    }

    fun saveProductCardToFile(card: ProductCard) {
        file.appendText("${card.naming}%${card.brand}%${card.price}%")
        when (card) {
            is ProductCardFood -> {
                file.appendText("${card.kCalories}%${WhichProductCard.FOOD}\n")
            }

            is ProductCardShoes -> {
                file.appendText("${card.size}%${WhichProductCard.SHOES}\n")
            }

            is ProductCardAppliences -> {
                file.appendText("${card.power}%${WhichProductCard.APPLIANCE}\n")
            }
        }
    }

    fun saveEmployeeToFile(employee: Employee) {
//        id: $id, name: $name, age: $age, Position: $position
        fileEmployee.appendText("${employee.id}%${employee.name}%${employee.age}%")
        fileEmployee.appendText(
            when (employee) {
                is Accountant -> ("${PositionJob.ACCOUNTANT}\n")
                is Assistant -> ("${PositionJob.ASSISTANT}\n")
                is Consultant -> ("${PositionJob.CONSULTANT}\n")
                is Director -> ("${PositionJob.DIRECTOR}\n")
                else -> ""
            }
        )
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val allCards = mutableListOf<ProductCard>()
        if (file.readText().isEmpty()) {
            return allCards
        }

        val cards = file.readText().trim().split("\n")
        for (card in cards) {
            val propertyCard = card.split("%")
            val name = propertyCard[0]
            val brand = propertyCard[1]
            val price = propertyCard[2].toInt()
            val cardType = propertyCard[propertyCard.lastIndex]
            val productCard = when (WhichProductCard.valueOf(cardType)) {
                WhichProductCard.SHOES -> {
                    val size = propertyCard[3].toInt()
                    ProductCardShoes(size, name, brand, price)

                }

                WhichProductCard.APPLIANCE -> {
                    val power = propertyCard[3].toInt()
                    ProductCardAppliences(power, name, brand, price)

                }

                WhichProductCard.FOOD -> {
                    val calories = propertyCard[3].toInt()
                    ProductCardFood(calories, name, brand, price)

                }
            }
            allCards.add(productCard)
        }
        return allCards
    }

    fun addCard() {
        print("Enter which card do you want to add. ")
        val whichProducts = WhichProductCard.entries
        for ((index, product) in whichProducts.withIndex()) {
            print("$index - ${product.title}")
            if (index != whichProducts.lastIndex) print(", ")
            else print(": ")
        }
        val whichProductIndex = readln().toInt()
        val whichCard = whichProducts[whichProductIndex]
        print("Enter name: ")
        val name = readln()
        print("Enter brand: ")
        val brand = readln()
        print("Enter price: ")
        val price = readln().toInt()

        val card = when (whichCard) {
            WhichProductCard.SHOES -> {
                print("Enter size: ")
                val size = readln().toInt()
                ProductCardShoes(size, name, brand, price)
            }

            WhichProductCard.APPLIANCE -> {
                print("Enter power: ")
                val power = readln().toInt()
                ProductCardAppliences(power, name, brand, price)
            }

            WhichProductCard.FOOD -> {
                print("Enter calories: ")
                val calories = readln().toInt()
                ProductCardFood(calories, name, brand, price)
            }
        }
        saveProductCardToFile(card)
    }

    fun showAllItems() {
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }

    fun registerEmployee() {
        // выбрать позицию (добавить Enum)
        val positionsJob = PositionJob.entries
        print("Choose position: ")
        //надо вынести в отд функцию
        for ((index, position) in positionsJob.withIndex()) {
            print("$index - ${position.title}")
            if (index != positionsJob.lastIndex) print(", ")
            else print(": ")
        }
        val positionJobIndex = readln().toInt()
        val positionJob = positionsJob[positionJobIndex]

        // Запросить данные: id: $id, name: $name, age: $age, Position: $position
        print("Enter id: ")
        val id = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter age: ")
        val age = readln().toInt()
        val employee = when (positionJob) {
            PositionJob.DIRECTOR -> {
                Director(name, age, id)
            }

            PositionJob.ACCOUNTANT -> {
                Accountant(name, age, id)
            }

            PositionJob.ASSISTANT -> {
                Assistant(name, age, id)
            }

            PositionJob.CONSULTANT -> {
                Consultant(name, age, id)
            }
        }
        saveEmployeeToFile(employee)
    }

    fun getEmployees(): List<Employee> {
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
            val position = employeeSplit[3]
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

    fun showAllEmployees() {
        val allEmployees = getEmployees()
        for (employee in allEmployees) {
            employee.getInfo()
        }
    }

    fun fireEmployee() {
        print("Enter id employee which you want to fire: ")
        val id = readln().toInt()
        val employeeAll = getEmployees()
        fileEmployee.writeText("")
        for (employee in employeeAll) {
            if (employee.id != id) {
                saveEmployeeToFile(employee)
            }
        }
    }
}