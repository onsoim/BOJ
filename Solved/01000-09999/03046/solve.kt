import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (R1, S) = readLine()!!.split(" ").map { it.toInt() }

    println(S * 2 - R1)
}