import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val ZERO = '0'.code
    var rem = 0

    for (i in readLine()!!) { rem = (rem * 10 + i.code - ZERO) % 20000303 }
    println(rem)
}