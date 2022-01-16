import java.io.*

fun nextPermutation(arr: Array<Int>, d: Int): Boolean {
    var i = d - 1
    while (i > 0 && arr[i - 1] > arr[i]) { i-- }

    if (i == 0) return false

    var j = d - 1
    while (arr[i - 1] >= arr[j]) j--

    arr[i - 1] = arr[j].also { arr[j] = arr[i - 1] }

    for (idx in 0..(d - 1 - i) / 2) { arr[i + idx] = arr[d - 1 - idx].also { arr[d - 1 - idx] = arr[i + idx] } }

    return true
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, d) = readLine()!!.split(" ").map { it.toInt() }

    val arr = Array(d, { i -> i })
    arr[1] = arr[0].also { arr[0] = arr[1] }

    var num = arr.joinToString("").toInt(d)
    if (num <= N) {
        while (nextPermutation(arr, d)) {
            num = arr.joinToString("").toInt(d)
            if (num > N) break
        }
    }

    println(if (N < num) num else "-1")
}