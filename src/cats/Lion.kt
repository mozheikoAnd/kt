package cats

class Lion(var numMemberFamily: Int): CatsFamily() {
    override fun eat() {
        println("Lion eats an antelope")
    }
}