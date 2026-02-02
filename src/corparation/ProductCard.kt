package corparation

open class ProductCard(
    val naming: String,
    val brand: String,
    val price: Int
) {
    open fun printInfo() {
        println("Product Card: $naming")
        println("Brand: $brand")
        println("Price: $price")
    }
}