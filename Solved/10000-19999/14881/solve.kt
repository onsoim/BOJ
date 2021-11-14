import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while(n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()

    while (T-- > 0) {
        val bottle = readLine()!!.split(" ").map { it.toInt() }

        if ( (bottle[0] >= bottle[2] || bottle[1] >= bottle[2]) && (bottle[2] % Euclidean(bottle[0], bottle[1]) == 0) ) println("YES")
        else println("NO")
    }
}