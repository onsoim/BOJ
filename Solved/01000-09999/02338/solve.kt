import java.util.*
import java.math.BigInteger

fun main() = with(Scanner(System.`in`)) {
    val A = readLine()!!.toBigInteger()
    val B = readLine()!!.toBigInteger()

    println(A+B)
    println(A-B)
    println(A*B)
}