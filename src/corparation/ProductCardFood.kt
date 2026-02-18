package corparation

data class ProductCardFood(
    val kCalories: Int,
    override val naming: String,
    override val brand: String,
    override val price: Int
) : ProductCard(naming, brand, price, WhichProductCard.FOOD) {
}