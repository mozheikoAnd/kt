package corparation

import java.io.File

class Accountant(
    name: String,
    age: Int
) : Employee(name, age) {

    val file = File("product_card.txt")

    override fun working() {
        while (true) {
            val operations = Operation.entries
            var operationIndex: Int
            while (true) {
                print("Enter your operation. ")
                for ((index, oper) in operations.withIndex()) {
                    print("$index - $oper")
                    if (index != operations.lastIndex) print(", ")
                    else print(": ")
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
            }
        }
    }

    fun deleteCard() {
        print("Enter name of card which you want to delete: ")
        val nameCard = readln()
//        val fileBegin = file.readText().trim()
//        val fileSplit = fileBegin.split("\n")
//        file.writeText("")
//        for (line in fileSplit) {
//            if (!(line.contains(nameCard))) {
//                file.appendText("$line\n")
//            }
//        }
        val cards = loadAllCards()
        for (card in cards) {
            if (card.naming == nameCard) {
                cards.remove(card)
                break
            }
        }
        file.writeText("")
        for (card in cards) {
            saveProductCardToFile(card)
        }
    }

    fun saveProductCardToFile(card: ProductCard) {
        file.appendText("${card.naming}%")
        file.appendText("${card.brand}%")
        file.appendText("${card.price}%")
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
        file.appendText("${readln()}%")
        print("Enter brand: ")
        file.appendText("${readln()}%")
        print("Enter price: ")
        file.appendText("${readln()}%")

        when (whichCard) {
            WhichProductCard.SHOES -> {
                print("Enter size: ")
                file.appendText("${readln()}%")
            }

            WhichProductCard.APPLIANCE -> {
                print("Enter power: ")
                file.appendText("${readln()}%")
            }

            WhichProductCard.FOOD -> {
                print("Enter calories: ")
                file.appendText("${readln()}%")
            }
        }
        file.appendText("${whichCard}\n")
    }

    fun showAllItems() {
        if (file.readText().isEmpty()) {
            return
        }
//        val cards = file.readText().trim().split("\n")
//        items.clear()
//        for (card in cards) {
//            val propertyCard = card.split("%")
//            val name = propertyCard[0]
//            val brand = propertyCard[1]
//            val price = propertyCard[2].toInt()
//            val cardType = propertyCard[propertyCard.lastIndex]
//            val productCard = when (WhichProductCard.valueOf(cardType)) {
//                WhichProductCard.SHOES -> {
//                    val size = propertyCard[3].toInt()
//                    ProductCardShoes(size, name, brand, price)
//
//                }
//
//                WhichProductCard.APPLIANCE -> {
//                    val power = propertyCard[3].toInt()
//                    ProductCardAppliences(power, name, brand, price)
//
//                }
//
//                WhichProductCard.FOOD -> {
//                    val calories = propertyCard[3].toInt()
//                    ProductCardFood(calories, name, brand, price)
//
//                }
//            }
//            items.add(productCard)
//        }
        val cards = loadAllCards()
        for (card in cards) {
            card.printInfo()
        }
    }
}