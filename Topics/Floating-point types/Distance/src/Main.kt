fun main() {
    val speed: Int
    val distance = readln().toInt()
    val time = readln().toInt()
    speed = distance / time
    println(speed.toDouble())
}