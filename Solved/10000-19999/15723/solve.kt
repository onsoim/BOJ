import kotlin.math.*

fun main() {
    val N = readLine()!!.toInt()
    val c = Array(26, { _ -> Array(26, { 0 } ) })
    
    repeat(N) {
        val tmp = readLine()!!.split(" ").map { it[0].code - 97 }
        c[tmp[0]][tmp[2]] = 1
    }

    repeat(26) { i->
        repeat(26) { j->
            repeat(26) { k->
                if (j != k && c[j][i] != 0 && c[i][k] != 0) {
                    c[j][k] = max(c[j][k], c[j][i] + c[i][k])
                }
            }
        }
    }

    val M = readLine()!!.toInt()

    repeat(M) {
        val tmp = readLine()!!.split(" ").map { it[0].code - 97 }
        println(if (c[tmp[0]][tmp[2]] != 0) "T" else "F")
    }
}