import java.io.*

fun isPrime(N: Int): Int {
    var i = 3

    if (N % 2 == 0) return 2

    while(i * i <= N) {
        if(N % i == 0) return i
        i += 2
    }

    return N
}

fun Euler_phi(N: Int): Int {
    var n = N
    var phi = 1

    if(N == 1) return N

    var i: Int
    var pow: Int

    do {
        i = isPrime(n)

        if (i == n) phi *= n - 1
        else {
            pow = 1

            while (n % i == 0) {
                n /= i
                pow *= i
            }
            phi *= pow / i * (i - 1)
        }

        if (n == 1) break
    } while (i != n)

    return phi
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var sum = 0
    repeat(readLine()!!.toInt() - 1) { sum += Euler_phi(it + 2) }
    println(sum)
}