import java.io.*
import java.util.*

lateinit var vertex: Array<ArrayList<Int>>
lateinit var inDegree: Array<Int>
val name = LinkedHashMap<String, Int>()
val rName = LinkedList<String>()
val pName = PriorityQueue<String>()

fun Topological_sort(N: Int) {
    val child = Array(N, { arrayListOf<Int>() })
    val queue = PriorityQueue<Pair<Int, Int>>(compareBy({ it.first }))

    inDegree.forEachIndexed { i, v ->
        if (v == 0) queue.offer(Pair(1, i))
    }
    println(queue.size)
    println(queue.map{ (p, i) -> rName[i] }.sorted().joinToString(" "))

    while (queue.isNotEmpty()) {
        val (d, i) = queue.poll()

        vertex[i].forEach {
            if (--inDegree[it] == 0) {
                child[i] += it
                queue.offer(Pair(d + 1, it))
            }
        }
    }

    while (pName.isNotEmpty()) {
        var n = pName.poll()

        val cnt = child[name.get(n)!!]
        val cName = if (cnt.size > 0) cnt.map{ rName[it] }.sorted().joinToString(" ", " ") else ""
        println("${n} ${cnt.size}${cName}")
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    vertex = Array(N, { arrayListOf<Int>() })
    inDegree = Array(N, { 0 })

    readLine()!!.split(" ").forEachIndexed { i, v ->
        name.put(v, i)
        rName += v
        pName.offer(v)
    }

    val M = readLine()!!.toInt()

    repeat(M) {
        val (X, Y) = readLine()!!.split(" ").map { name.get(it)!! }

        vertex[Y] += X
        inDegree[X]++
    }

    Topological_sort(N)

}