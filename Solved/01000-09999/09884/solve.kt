import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while (m != 0) { n = m.also { m = n % m } }

    return n
}

fun main() = with(Scanner(System.`in`)) {
    val (A, B) = readLine()!!.split(" ").map { it.toInt() }

    println(Euclidean(A, B))
}