import java.io.*
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val tree = Array(N + 1, { _ -> arrayListOf<Int>() })
    val level = Array(N + 1, { 0 })
    var root = -1

    repeat(N) { index ->
        val tmp = readLine().toInt()

        if (tmp == -1) root = index + 1
        else tree[tmp] += index + 1
    }

    val traversal = arrayListOf<Pair<Int, Int>>()
    traversal.add(Pair(root, 0))

    while (traversal.isNotEmpty()) {
        val (n, l) = traversal.removeFirst()

        tree[n].forEach {
            traversal.add(Pair(it, l + 1))
            level[it] = l + 1
        }
    }

    for (i in 1..N) println(level[i])
}