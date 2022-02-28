import java.io.*
import kotlin.math.*

fun LCS(S1: String, S2: String): Int {
    val L1 = S1.length
    val L2 = S2.length
    val arr = Array(L1 + 1, { Array(L2 + 1, { 0 }) })

    S1.forEachIndexed { i, iv ->
        S2.forEachIndexed { j, jv ->
            if (iv == jv) arr[i + 1][j + 1] = arr[i][j] + 1
            else arr[i + 1][j + 1] = max(arr[i][j + 1], arr[i + 1][j])
        }
    }

    return arr[L1][L2]
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    println(LCS(readLine(), readLine()))
}