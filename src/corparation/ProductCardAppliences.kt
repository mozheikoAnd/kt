package corparation

data class ProductCardAppliences(
    val power: Int,
    override val naming: String,
    override val brand: String,
    override val price: Int
) : ProductCard(naming, brand, price, WhichProductCard.APPLIANCE) {
}