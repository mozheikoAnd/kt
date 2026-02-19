package exception

fun main() {

    try {
        val intArray = arrayOf(1,2,3,4,5)
        println(intArray[5])
    }catch (e: ArrayIndexOutOfBoundsException){
        println("Amount element 5, but max index is 4")
    }
}