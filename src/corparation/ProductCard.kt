package corparation

open class ProductCard(
    val naming: String,
    val brand: String,
    val price: Int,
    val productType: WhichProductCard
) {
    open fun printInfo() {
        print("Product Card: $naming  Brand: $brand  Price: $price Product type: ${productType.title}")
    }
}