package corparation

class ProductCardFood(
    val kCalories: Int,
    naming: String,
    brand: String,
    price: Int
) : ProductCard(naming, brand, price, WhichProductCard.FOOD) {
    override fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "${super.toString()}  KCalories: $kCalories"
    }
}