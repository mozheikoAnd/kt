package corparation

class Director(
    name: String,
    age: Int = 0
): Employee(name, age) {
    fun getCoffee(assistant: Assistant){
        val typeCoffe = assistant.bingCoffee()
        println("Thanks ${assistant.name}. The $typeCoffe will be testy")
    }
    fun cickConsultant(consultant: Consultant){
        val count = consultant.observe()
        println("${consultant.name} end serve $count customers")
    }

    override fun working() {
        println("Employee $name is drink coffee")
    }
}