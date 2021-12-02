import java.util.*
import java.math.BigInteger

fun Euclidean(N: BigInteger, M: BigInteger): BigInteger {
    var n = N
    var m = M
    
    if (n < m) n = m.also { m = n }
    while (n % m != 0.toBigInteger() ) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    val (A, B) = readLine()!!.split(" ").map { it.toBigInteger() }

    println(A * B / Euclidean(A, B))
}