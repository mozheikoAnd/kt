package corparation

import kotlin.Int

class Assistant (
    name: String,
    age: Int = 0,
    id: Int
) : Employee(name, age, id) {
    fun bingCoffee(count: Int = 1, typeCoffee: String = "Cappuccino"): String {
        repeat(count) {
            println("Stand up")
            println("Go to the coffee machine")
            println("Check state of coffee machine")
            println("Push \"$typeCoffee\" button")
            println("Wait cooking $typeCoffee")
            println("Take a cup of $typeCoffee and bring to the boss")
        }
        return typeCoffee
    }

    override fun working() {
        println("Employee $name is answer on call..")
    }
    override fun getInfo() {
        super.getInfo()
        println("Position: ${PositionJob.ASSISTANT.title}")
    }
}