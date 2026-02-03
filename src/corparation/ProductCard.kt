package corparation

open class ProductCard(
    val naming: String,
    val brand: String,
    val price: Int
) {
    open fun printInfo() {
        print("Product Card: $naming  Brand: $brand  Price: $price")
    }
}