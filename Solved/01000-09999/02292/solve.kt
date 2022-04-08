import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    var base = 6
    var sum = 1

    while (sum < N) {
        sum += base
        base += 6
    }
    
    println(base / 6)
}