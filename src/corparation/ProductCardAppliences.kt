package corparation

class ProductCardAppliences(
    val power: Int,
    naming: String,
    brand: String,
    price: Int
) : ProductCard(naming, brand, price, WhichProductCard.APPLIANCE) {
    override fun printInfo() {
        println(this)
    }

    override fun toString(): String {
        return "${super.toString()}  Power: $power"
    }
}