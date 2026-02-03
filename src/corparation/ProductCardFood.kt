package corparation

class ProductCardFood(
    val kCalories: Int,
    naming: String,
    brand: String,
    price: Int
) : ProductCard(naming, brand, price) {
    override fun printInfo() {
        super.printInfo()
        println("  KCalories: $kCalories")
    }
}