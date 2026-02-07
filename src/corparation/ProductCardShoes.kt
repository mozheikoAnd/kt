package corparation

class ProductCardShoes(
    val size: Int,
    naming: String,
    brand: String,
    price: Int,
) : ProductCard(naming, brand, price, WhichProductCard.SHOES) {
    override fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "${super.toString()}  Size: $size"
    }
}