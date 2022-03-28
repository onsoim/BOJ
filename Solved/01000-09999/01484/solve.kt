import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val G = readLine()!!.toInt()

    var i = 1
    var j = 2
    var I = i * i
    var J = j * j

    var flag = true
    while (i != j) {
        if (J - I < G) {
            j++
            J = j * j
        }
        else {
            if (J - I == G) {
                flag = false
                println(j)
            }
            i++
            I = i * i
        }
    }
    if (flag) println(-1)
}