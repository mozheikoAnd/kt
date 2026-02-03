package corparation

class ProductCardAppliences(
    val power: Int,
    naming: String,
    brand: String,
    price: Int
) : ProductCard(naming, brand, price) {
    override fun printInfo() {
        super.printInfo()
        println("  Power: $power")
    }
}