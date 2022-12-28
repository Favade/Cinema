fun main() {
    println(expr(readln().toDouble(),readln().toDouble(),readln().toDouble(),readln().toDouble()))
}

fun expr(a: Double, b: Double, c: Double, d: Double): Double {
    return a * 10.5 + b * 4.4 + (c + d) / 2.2
}