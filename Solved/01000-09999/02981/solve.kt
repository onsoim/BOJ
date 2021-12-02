import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun composite(n: Int): List<Int> {
    val forward = arrayListOf<Int>()
    val reverse = arrayListOf<Int>(n)

    var i = 2
    while (i*i <= n) {
        if (n % i == 0) {
            forward.add(i)
            reverse.add(n/i)
        }
        i++
    }

    return (forward + reverse.reversed()).distinct()
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

    println(composite(gcd).joinToString(" "))
}