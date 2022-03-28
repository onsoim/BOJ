import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val S = readLine()

    val alpha = Array(26, { 0 })
    var cnt = 0
    var l = 1
    var start = 0

    repeat(S.length) {
        val idx = S[it].code - 97

        if (alpha[idx] == 0) {
            if (cnt == N) {
                do {
                    if (--alpha[S[start++].code - 97] == 0) cnt--
                } while (cnt == N)
            }
            cnt++
        }
        alpha[idx]++
        if (it - start > l) l = it - start
    }

    println(l + 1)
}