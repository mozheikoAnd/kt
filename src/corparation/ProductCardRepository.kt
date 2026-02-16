package corparation

import java.io.File

class ProductCardRepository {

    private val fileProductCard = File("product_card.txt")
    val productCards = loadAllCards()

    fun deleteCard(nameCard: String) {
        for (card in productCards) {
            if (card.naming == nameCard) {
                productCards.remove(card)
                break
            }
        }
    }

    private fun loadAllCards(): MutableList<ProductCard> {
        val allCards = mutableListOf<ProductCard>()
        if (fileProductCard.readText().isEmpty()) {
            println("List of product cards is empty")
            return allCards
        }

        val cards = fileProductCard.readText().trim().split("\n")
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
    fun addProductCard(productCard: ProductCard) {
        productCards.add(productCard)
    }
    fun saveProductCards() {
        saveProductCardToFile()
    }

    private fun saveProductCardToFile() {
        val content: StringBuilder = StringBuilder()
        for (card in productCards) {
            content.append("${card.naming}%${card.brand}%${card.price}%")
            when (card) {
                is ProductCardFood -> {
                    content.append("${card.kCalories}%${WhichProductCard.FOOD}\n")
                }

                is ProductCardShoes -> {
                    content.append("${card.size}%${WhichProductCard.SHOES}\n")
                }

                is ProductCardAppliences -> {
                    content.append("${card.power}%${WhichProductCard.APPLIANCE}\n")
                }
            }
        }
        fileProductCard.writeText(content.toString())
    }
}