package corparation

class ProductCardShoes(
    val size: Int,
    naming: String,
    brand: String,
    price: Int
) : ProductCard(naming, brand, price, WhichProductCard.SHOES) {
    override fun printInfo() {
        super.printInfo()
        println("  Size: $size")
    }
}