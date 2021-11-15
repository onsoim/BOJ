import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val T = readLine()!!.toInt()
    
    for (i in 1 .. T) {
        var N = readLine()!!.toInt()
        var P = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
        var p = arrayListOf<Int>()

        while (N-- > 0) {
            var rm = P[P.size - 1]
            P.remove(rm)

            rm = rm / 4 * 3
            P.remove(rm)
            p.add(rm)
        }
        println("Case #${i}: ${p.reversed().joinToString(" ")}")
    }
}