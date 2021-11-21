import java.util.*
import java.math.BigInteger

fun Play(N: BigInteger, M: BigInteger): Boolean {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    if ( (n % m == BigInteger.ZERO) || (n > m * 2.toBigInteger()) ) return true
    n %= m

    return !Play(n, m)
}

fun main() = with(Scanner(System.`in`)) {
    val (N, M) = readLine()!!.split(" ").map { it.toBigInteger() }

    if (Play(N, M)) { println("win") }
    else { println("lose") }
}