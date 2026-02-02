package gui

class Rectangle {
    val width: Int
    val height: Int

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
    }

    fun draw () {
        repeat(height) {
            repeat(width) {
                print("* ")
            }
            println()
        }
    }
}