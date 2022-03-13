import java.io.*
import kotlin.math.*

fun LCS(S1: String, S2: String): Array<Array<Int>> {
    val L1 = S1.length
    val L2 = S2.length
    val arr = Array(L1 + 1, { Array(L2 + 1, { 0 }) })

    S1.forEachIndexed { i, iv ->
        S2.forEachIndexed { j, jv ->
            if (iv == jv) arr[i + 1][j + 1] = arr[i][j] + 1
            else arr[i + 1][j + 1] = max(arr[i][j + 1], arr[i + 1][j])
        }
    }

    println(arr[L1][L2])

    return arr
}

fun LCS_find(arr: Array<Array<Int>>): List<Int> {
    val sub = arrayListOf<Int>()

    var i = arr.size - 1
    var j = arr[0].size - 1

    while (arr[i][j] != 0) {
        if (arr[i - 1][j] == arr[i][j]) i--
        else if (arr[i][j - 1] == arr[i][j]) j--
        else {
            i--
            sub += --j
        }
    }

    return sub.reversed()
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val S1 = readLine()
    val S2 = readLine()

    LCS_find(LCS(S1, S2)).forEach { print(S2[it]) }
}