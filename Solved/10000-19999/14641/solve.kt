import java.io.*

fun floyd_warshall(N: Int, arr: Array<Array<Boolean>>) {
    repeat(N) { i->
        repeat(N) { j->
            repeat(N) { k->
                if (arr[j][i] == true && arr[i][k] == true) arr[j][k] = true
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }

    val arr = Array(26, { Array(26, { false }) })
    repeat(26) { i-> arr[i][i] = true}

    repeat(m) {
        val (a, b) = readLine()!!.split(" ").map { it[0].code - 97 }
        arr[a][b] = true
    }

    floyd_warshall(26, arr)

    repeat(n) {
        val (a, b) = readLine()!!.split(" ")
        var flag = true
        
        if (a.length == b.length) {
            repeat(a.length) { i->
                if ( !arr[a[i].code - 97][b[i].code - 97] ) flag = false
            }
        }
        else flag = false

        println(if (flag) "yes" else "no")
    }

}