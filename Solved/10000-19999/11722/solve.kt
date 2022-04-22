import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun LDS(L: List<Int>): Int {
    val l = LinkedList<Int>()

    L.forEach { Lv ->
        if (l.size != 0) {
            for (i in 0 .. l.size - 1) {
                if (Lv >= l[i]) {
                    l[i] = Lv
                    break
                }
                else if (i == l.size - 1) l.offer(Lv)
            }
        }
        else l.offer(Lv)
    }

    return l.size
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get()[0]
    val A = get()

    println(LDS(A))
}