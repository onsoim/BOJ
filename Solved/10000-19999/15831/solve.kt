import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (N, B, W) = readLine()!!.split(" ").map { it.toInt() }
    val trail = readLine()

    var i = 0
    var j = 0

    var w = 0
    var b = 0
    var l = 0

    while (j < N) {
        if (trail[j].code == 66) {
            if (++b > B) while (b > B) if (trail[i++].code == 66) b-- else w--
        } else w++

        if (w >= W && w + b > l) l = w + b
        j++
    }
    println(l)
}