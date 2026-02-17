package corparation

class Accountant(
    name: String,
    age: Int,
    id: Int
) : Employee(name, age, id), Producer, Cleaner {

    val productCardRepository = ProductCardRepository
    val employeeRepository = EmployeeRepository

    override fun clean() {
        println("Accountant cleaning.")
    }

    override fun byItems() {
        println("Accountant buying items.")
    }

    override fun copy(age: Int): Accountant {
        return Accountant(this.name, age, this.id)
    }

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
                Operation.EXIT -> {
                    productCardRepository.saveProductCards()
                    employeeRepository.saveEmployee()
                    break
                }

                Operation.ADD_CARD -> addCard()
                Operation.SHOW_ALL_CARDS -> showAllItems()
                Operation.DELETE_CARD -> deleteCard()
                Operation.REGISTER_EMPLOYEE -> registerEmployee()
                Operation.FIRE_EMPLOYEE -> fireEmployee()
                Operation.SHOW_ALL_EMPLOYEE -> showAllEmployees()
                Operation.CHANGE_AGE -> changeAge()
            }
        }
    }


    private fun deleteCard() {
        print("Enter name of card which you want to delete: ")
        val nameCard = readln()
        productCardRepository.deleteCard(nameCard)
    }

    private fun addCard() {
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
        productCardRepository.addProductCard(card)
    }

    private fun showAllItems() {
        val cards = productCardRepository.productCards
        for (card in cards) {
            card.printInfo()
        }
    }

    private fun registerEmployee() {
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
        employeeRepository.registerEmployee(employee)
    }

    private fun showAllEmployees() {
        val allEmployees = employeeRepository.allEmployees
        for (employee in allEmployees) {
            employee.getInfo()
        }
    }

    private fun fireEmployee() {
        print("Enter id employee which you want to fire: ")
        val id = readln().toInt()
        employeeRepository.fireEmployee(id)
    }

    private fun changeAge() {
        println("Enter id of employee: ")
        val id = readln().toInt()
        println("Enter a new age: ")
        val age = readln().toInt()
        employeeRepository.changeAge(id, age)
    }
}