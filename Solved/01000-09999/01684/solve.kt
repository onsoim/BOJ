import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (m != 0) { n = m.also { m = n % m } }

    return n
}

fun main() = with(Scanner(System.`in`)) {
    var N = nextInt() - 2
    
    var a = nextInt()
    var b = nextInt()
    var gcd = b - a
    
    while (N-- > 0) {
        a = b.also { b = nextInt() }
        gcd = Euclidean(gcd, b - a)
    }

    if (gcd < 0) gcd *= -1

    println(gcd)
}