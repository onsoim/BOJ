import java.io.*

fun isPrime(N: Long): Long {
    var i = 3L

    if (N % 2 == 0L) return 2

    while(i * i <= N) {
        if(N % i == 0L) return i
        i += 2
    }

    return N
}

fun Euler_phi(N: Long): Long {
    var n = N
    var phi = 1L

    if(N == 1L) return N

    var i: Long
    var pow: Long

    do {
        i = isPrime(n)

        if (i == n) phi *= n - 1
        else {
            pow = 1L

            while (n % i == 0L) {
                n /= i
                pow *= i
            }
            phi *= pow / i * (i - 1)
        }

        if (n == 1L) break
    } while (i != n)

    return phi
}

fun Euclidean(N: Long, M: Long): Long {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (m != 0L) { n = m.also { m = n % m } }

    return n
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val prime = listOf<Long>(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47)
    var min = 1.0
    var p = 0L
    var q = 0L

    var N = 1L
    val n = readLine()!!.toLong()
    for (k: Long in prime) {
        N *= k
        if (N > n) break

        val e = Euler_phi(N)
        val m = e.toDouble() / N
        
        if (min > m) {
            min = m
            p = N - e
            q = N
        }
    }

    val gcd = Euclidean(p, q)
    println("${p / gcd}/${q / gcd}")
}