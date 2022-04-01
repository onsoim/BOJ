import java.io.*
import java.util.*

lateinit var L: List<Int>
val l = ArrayList<Int>()

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun BinarySearch(lt: Int, rt: Int, m: Int): Int {
    var Lt = lt
    var Rt = rt

    while (Lt != Rt) {
        val Mt = (Lt + Rt) / 2

        if (l[Mt] >= m) Rt = Mt
        else Lt = Mt + 1
    }

    return Rt
}

fun LIS(): Int {
    l.add(L[0])
    L.forEach {
        if (it > l.last()) l.add(it)
        else l[BinarySearch(0, l.size, it)] = it
    }

    return l.size
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = get()[0]
    L = get()

    println(LIS())
}