import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val (A, B) = readLine()!!.split(" ").map { it.toInt() }
    println("${B - A} ${B}")
}