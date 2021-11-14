import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while(n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    val (n, m) = readLine()!!.split(":").map { it.toInt() }

    val gcd = Euclidean(n, m)
    println("${n/gcd}:${m/gcd}")
}