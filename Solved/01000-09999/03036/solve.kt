import java.util.*

fun Euclidean(N: Int, M: Int): Int {
    var n = N
    var m = M

    if (n < m) n = m.also { m = n }
    while(n % m != 0) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    val N = readLine()!!.toInt()
    val r = readLine()!!.split(" ").map { it.toInt() }

    for (i in 1..N-1){
        val gcd = Euclidean(r[0], r[i])
        println("${r[0]/gcd}/${r[i]/gcd}")
    }
}