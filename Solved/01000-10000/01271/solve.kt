import java.util.*
import java.math.BigInteger

fun main() = with(Scanner(System.`in`)) {
    val line = readLine()!!.split(" ").map { it.toBigInteger() }

    println( line[0] / line[1] )
    println( line[0] % line[1] )
}