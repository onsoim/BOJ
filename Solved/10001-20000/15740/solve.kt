import java.util.*
import java.math.BigInteger

fun main() = with(Scanner(System.`in`)) {
    var (A, B) = readLine()!!.split(" ").map { it.toBigInteger() }

    println(A+B)
}