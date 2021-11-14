import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while(n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    var N = nextInt() - 1
    var n = N

    var start = 0
    var end = 0
    var gcd = 0
    var cnt = 0

    while (n-- > 0) {
        if (start == 0) {
            start = nextInt().also { end = nextInt() }
            gcd = end - start
            cnt = gcd
        }
        else {
            start = end.also { end = nextInt() }
            gcd = Euclidean(gcd, end - start)
            cnt += end - start
        }
    }
    println(cnt / gcd - N)
}