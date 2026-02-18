package corparation

data class ProductCardShoes(
    val size: Int,
    override val naming: String,
    override val brand: String,
    override val price: Int,
) : ProductCard(naming, brand, price, WhichProductCard.SHOES) {
}