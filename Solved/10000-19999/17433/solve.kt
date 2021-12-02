import java.util.*
import java.math.BigInteger

val B0 = BigInteger.ZERO
val B1 = BigInteger.ONE

fun Euclidean(N: BigInteger, M: BigInteger): BigInteger {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (m != B0) n = m.also { m = n % m }

    return n
}

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()
    var gcd = B0
    
    while (T-- > 0) {
        val N = readLine()!!.toInt()
        val n = readLine()!!.split(" ").map { it.toBigInteger() }
        
        gcd = n[1] - n[0]
        for (i in 2..n.size - 1) gcd = Euclidean(gcd, n[i] - n[i-1])

        if (gcd == B0) println("INFINITY")
        else {
            if (gcd < B0) gcd *= - B1
            println(gcd)
        }
    }
}