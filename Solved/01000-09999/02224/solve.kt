import kotlin.math.*
import java.util.*

fun main() {
    val N = readLine()!!.toInt()
    val c = Array(58, { _ -> Array(58, { 0 } ) })
    val lazy = arrayListOf<Pair<Char, Char>>()
    
    repeat(N) {
        val tmp = readLine()!!.split(" ").map { it[0].code - 65 }
        c[tmp[0]][tmp[2]] = 1
    }

    repeat(58) { i->
        repeat(58) { j->
            repeat(58) { k->
                if (j != k && c[j][i] != 0 && c[i][k] != 0) {
                    c[j][k] = max(c[j][k], c[j][i] + c[i][k])
                }
            }
        }
    }

    repeat(58) { i ->
        repeat(58) { j ->
            if (c[i][j] != 0) { lazy.add(Pair((i + 65).toChar(), (j + 65).toChar())) }
        }
    }

    println(lazy.size)
    lazy.forEach { it ->
        println("${it.first} => ${it.second}")
    }
}