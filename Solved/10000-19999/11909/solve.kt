import java.io.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()

    val arr = Array(N, { Array(N, { 0 }) })
    val dist= Array(N, { Array(N, { 0 }) })

    repeat(N) { i ->
        readLine()!!.split(" ").map {
            it.toInt()
        }.forEachIndexed { j, v -> 
            arr[i][j] = v
        }
    }
    
    repeat(N) { i ->
        repeat(N) { j ->
            if (i != 0 || j != 0) {
                val tmp = arrayListOf<Int>()

                if (i > 0)
                    tmp.add(
                        dist[i - 1][j] + if (arr[i][j] < arr[i - 1][j]) 0 else arr[i][j] - arr[i - 1][j] + 1
                    )

                if (j > 0)
                    tmp.add(
                        dist[i][j - 1] + if (arr[i][j] < arr[i][j - 1]) 0 else arr[i][j] - arr[i][j - 1] + 1
                    )

                dist[i][j] = tmp.minOrNull()!!
            }
        } 
    }

    println(dist[N - 1][N - 1])
}