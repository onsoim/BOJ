import java.io.*

fun floyd_warshall(N: Int, arr: Array<Array<Int>>) {
    repeat(N) { i->
        repeat(N) { j->
            repeat(N) { k->
                if (arr[j][i] == arr[i][k] && arr[j][k] == 0) arr[j][k] = arr[j][i]
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    val arr = Array(n, { Array(n, { 0 }) })

    repeat(k) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
        arr[a][b] = -1
        arr[b][a] = 1
    }

    floyd_warshall(n, arr)

    repeat(readLine()!!.toInt()) {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
        println(arr[a][b])
    }
}