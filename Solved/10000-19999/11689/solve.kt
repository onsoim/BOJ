import java.io.*
import java.util.*

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

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) { println(Euler_phi(readLine()!!.toLong())) }