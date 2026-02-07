package corparation

abstract class ProductCard(
    val naming: String,
    val brand: String,
    val price: Int,
    val productType: WhichProductCard
) {
    abstract fun printInfo()

    override fun toString(): String {
        return "Product Card: $naming  Brand: $brand  Price: $price Product type: ${productType.title}"
    }
}