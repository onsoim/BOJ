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
    var (N, M) = readLine()!!.split(" ").map { it.toBigInteger() }
    
    do {
        if (Play(N, M)) { print("A") }
        else { print("B") }
        println(" wins")

        val tmp = readLine()!!.split(" ").map { it.toBigInteger() }
        N = tmp[0].also { M = tmp[1] }
    }while ( (N != BigInteger.ZERO) && (M != BigInteger.ZERO) )
}