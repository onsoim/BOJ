import java.util.*

fun factorization(N: Int) {
    var n = N
    var i = 2

    while (n != 1) {
        while (n % i == 0) {
            println(i)
            n /= i
        }

        if (i != 2) i += 2
        else i++
    }
}

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()

    factorization(N)
}