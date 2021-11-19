import java.util.*
import java.math.BigInteger

fun B(n: Int): BigInteger { return n.toBigInteger() }

fun Euclidean(N: BigInteger, M: BigInteger): BigInteger {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (m != BigInteger.ZERO) n = m.also { m = n % m }

    return n
}

fun main() = with(Scanner(System.`in`)) {
    val pqr = readLine()!!.split(" ").map { it.toBigInteger() }

    var x_n = B(3) * pqr[0] - B(2) * pqr[1] + pqr[2]
    var y_n = pqr[0] + B(2) * pqr[1] - pqr[2]

    var x_d = B(2) * (pqr[0] + pqr[2])
    var y_d = x_d

    val x_g = Euclidean(x_n, x_d)
    val y_g = Euclidean(y_n, y_d)

    x_n /= x_g
    x_d /= x_g

    y_n /= y_g
    y_d /= y_g

    if ( (x_n > BigInteger.ZERO) && (y_n > BigInteger.ZERO) && (x_n  < x_d) && (y_n < y_d)) {
        println("${x_n}/${x_d} ${y_n}/${y_d}")
    } else { println("-1") }
}