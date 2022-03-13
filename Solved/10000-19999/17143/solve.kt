import java.io.*
import java.util.*

fun get() = readLine()!!.split(" ").map { it.toInt() }

fun changeDirection(d: Int): Int {
    return if (d % 2 == 0) d + 1 else d - 1
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (R, C, M) = get()
    var sea = Array(R, { Array(C, { -1 }) })
    val shark = arrayListOf<Triple<Int, Int, Boolean>>()
    val D = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1))

    repeat(M) { i ->
        val (r, c, s, d, z) = get()
        sea[r - 1][c - 1] = i
        shark.add(Triple(r * 1000 + c - 1001, s * 1000000 + (d - 1) * 100000 + z, true))
    }

    var sum = 0

    repeat(C) { i ->
        for (j in 0..R - 1) {
            if (sea[j][i] != -1) {
                sum += shark[sea[j][i]].second % 100000
                shark[sea[j][i]] = Triple(0, 0, false)
                sea[j][i] = -1
                break
            }
        }

        sea = Array(R, { Array(C, { -1 }) })
        shark.forEachIndexed { k, (rc, sdz, live) ->
            if (live) {
                var r = rc / 1000
                var c = rc % 1000

                val s = sdz / 1000000
                var d = sdz / 100000 % 10
                var z = sdz % 100000

                r = (r + D[d].first  * s) % ((R - 1) * 2)
                c = (c + D[d].second * s) % ((C - 1) * 2)

                while (true) {
                         if (r <     0) r *= -1
                    else if (r > R - 1) r = R * 2 - r - 2
                    else if (c <     0) c *= -1
                    else if (c > C - 1) c = C * 2 - c - 2
                    else break

                    d = changeDirection(d)
                }

                if (sea[r][c] != -1) {
                    if (z > shark[sea[r][c]].second % 100000) {
                        shark[sea[r][c]] = Triple(0, 0, false)
                        shark[k] = Triple(r * 1000 + c, s * 1000000 + d * 100000 + z, true)
                        sea[r][c] = k
                    } else shark[k] = Triple(0, 0, false)
                }
                else {
                    shark[k] = Triple(r * 1000 + c, s * 1000000 + d * 100000 + z, true)
                    sea[r][c] = k
                }
            }
        }
    }
    println(sum)
}