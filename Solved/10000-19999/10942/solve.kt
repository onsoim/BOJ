import java.io.*
import java.util.*

lateinit var arr: Array<Array<Int>>
lateinit var n: List<Int>

fun get(m: Int) = readLine()!!.split(" ").map { it.toInt() - m }

fun isPalindrome(S: Int, E: Int): Int {
    if (arr[S][E] == 2) {
        if (S == E) arr[S][E] = 1
        else {
            val diff = E - S

            if (diff == 1)
                arr[S][E] = if (n[S] == n[E]) 1 else 0
            else
                arr[S][E] = if (n[S] == n[E] && isPalindrome(S + 1, E - 1) == 1) 1 else 0
        }
    }

    return arr[S][E]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get(0)[0]
    arr = Array(N, { Array(N, { 2 }) })
    n = get(0)

    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(get(0)[0]) {
        val (S, E) = get(1)

        bw.write("${isPalindrome(S, E)}\n")
    }

    bw.flush()
    bw.close()
}