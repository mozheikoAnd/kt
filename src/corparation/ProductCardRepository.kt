package corparation

import java.io.File

class ProductCardRepository {

    private val fileProductCard = File("product_card.txt")

    fun deleteCard(nameCard: String) {
        val cards = loadAllCards()
        fileProductCard.writeText("")
        for (card in cards) {
            if (card.naming != nameCard) {
                saveProductCardToFile(card)
            }
        }
    }

    fun loadAllCards(): MutableList<ProductCard> {
        val allCards = mutableListOf<ProductCard>()
        if (fileProductCard.readText().isEmpty()) {
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

    fun saveProductCard(card: ProductCard) {
        saveProductCardToFile(card)
    }

    private fun saveProductCardToFile(card: ProductCard) {
        fileProductCard.appendText("${card.naming}%${card.brand}%${card.price}%")
        when (card) {
            is ProductCardFood -> {
                fileProductCard.appendText("${card.kCalories}%${WhichProductCard.FOOD}\n")
            }

            is ProductCardShoes -> {
                fileProductCard.appendText("${card.size}%${WhichProductCard.SHOES}\n")
            }

            is ProductCardAppliences -> {
                fileProductCard.appendText("${card.power}%${WhichProductCard.APPLIANCE}\n")
            }
        }
    }
}