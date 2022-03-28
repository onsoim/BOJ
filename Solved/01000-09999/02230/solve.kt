import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    val A = arrayListOf<Int>()

    repeat(N) { A += readLine()!!.toInt() }
    A.sort()

    var D = A[N - 1] - A[0]
    var i = 0
    var j = 1

    while (j < N) {
        val d = A[j] - A[i]

        if (d < M) j++
        else {
            if (D > d) D = d
            if (++i == j) j = i + 1
        }
    }
    println(D)
}