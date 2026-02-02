package corparation

class Accountant(
    name: String,
    age: Int
) : Employee(name, age) {
    override fun working() {
        while (true) {
            val operations = Operation.entries
            print("Enter your operation. ")
            for ((index,oper) in operations.withIndex()) {
                print("$index - $oper")
                if (index != operations.lastIndex) print(", ")
                else print(": ")
            }
            val operationIndex = readln().toInt()
            val operation = operations[operationIndex]
            when (operation) {
                Operation.EXIT -> break
                Operation.ADD_CARD -> addCard()
            }
        }
    }

    fun addCard(){
        print("Enter which card do you want to add(1- Shoes, 2 - Appliances, 3 - Food): ")
        val whichCard = readln().toInt()
        print("Enter name: ")
        val name = readln()
        print("Enter brand: ")
        val brand = readln()
        print("Enter price: ")
        val price = readln().toInt()

        val productCard = when (whichCard) {
            1 -> {
                print("Enter size: ")
                val size = readln().toInt()
                ProductCardShoes(size, name, brand, price)
            }
            2 -> {
                print("Enter power: ")
                val power = readln().toInt()
                ProductCardAppliences(power, name, brand, price)
            }
            3 -> {
                print("Enter calories: ")
                val calories = readln().toInt()
                ProductCardFood(calories, name, brand, price)
            }
            else -> ProductCard(name,brand,price)
        }
        productCard.printInfo()
    }
}