package cats

open class CatsFamily (val numLegs: Int = 4) {
    open fun eat(){
        println("Eat")
    }
}