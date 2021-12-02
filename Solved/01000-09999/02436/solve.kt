import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while(n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun composite(n: Int): Array<Int> {
    var a = 1
    var b = n

    var i = 2
    while (i * i <= n) {
        if ( (n % i == 0) && (Euclidean(i, n/i) == 1) ) a = i.also { b = n / i }
        i++
    }

    return arrayOf(a, b)
}

fun main() = with(Scanner(System.`in`)) {
    val (gcd, lcm) = readLine()!!.split(" ").map { it.toInt() }

    val (a, b) = composite(lcm/gcd)

    println("${gcd * a} ${gcd * b}")
}