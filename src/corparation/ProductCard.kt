package corparation

abstract class ProductCard(
    open val naming: String,
    open val brand: String,
    open val price: Int,
    val productType: WhichProductCard
) {
    fun printInfo(){
        println(this)
    }

}