import java.lang.Exception

fun solution() {
    val numOne = readln().toInt()
    val numTwo = readln().toInt()

    try {
        println(numOne / numTwo)
    } catch (e: Exception) {
        println(e.message)
    } finally {
        println("This is the end, my friend.")
    }
}