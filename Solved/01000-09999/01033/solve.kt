import java.util.*
import java.math.BigInteger

fun B(n: Int): BigInteger { return n.toBigInteger() }
fun I(n: BigInteger): Int { return n.toInt() }

fun Euclidean(N: BigInteger, M: BigInteger): BigInteger {
    var n = N
    var m = M
    
    if (n < m) n = m.also { m = n }
    while (n % m != B(0) ) { n = m.also { m = n % m } }

    return m
}

fun main() = with(Scanner(System.`in`)) {
    var N = readLine()!!.toInt()
    val ratios = Array(N, {_ -> B(0)})
    var flag = true
    val keep = arrayListOf<Int>()

    while (N-- > 1) {
        val r = readLine()!!.split(" ").map { it.toInt() }

        if (ratios[r[0]] == B(0)) {
            if (ratios[r[1]] == B(0)) {
                if (flag) {
                    ratios[r[0]] = B(r[2]).also { ratios[r[1]] = B(r[3]) }
                    flag = false
                }
                else r.forEach { keep.add(it.toInt()) }
            }
            else {
                val tmp = B(r[3]) / Euclidean(ratios[r[1]], B(r[3]))
                for ( i in 0..ratios.size-1 ) ratios[i] *= tmp
                ratios[r[0]] = B(r[2]) * ratios[r[1]] / B(r[3])
            }
        }
        else if (ratios[r[1]] == B(0)) {
            val tmp = B(r[2]) / Euclidean(ratios[r[0]], B(r[2]))
            for ( i in 0..ratios.size-1 ) ratios[i] *= tmp
            ratios[r[1]] = B(r[3]) * ratios[r[0]] / B(r[2])
        }
    }

    while (keep.size != 0) {
        if (ratios[keep[0]] == B(0)) {
            if (ratios[keep[1]] == B(0)) {
                for (i in 1..4) {
                    keep.add(keep[0])
                    keep.removeAt(0)
                }
            }
            else {
                val tmp = B(keep[3]) / Euclidean(ratios[keep[1]], B(keep[3]))
                for ( i in 0..ratios.size-1 ) ratios[i] *= tmp
                ratios[keep[0]] = B(keep[2]) * ratios[keep[1]] / B(keep[3])
                for (i in 1..4) { keep.removeAt(0) }
            }
        }
        else {
            val tmp = B(keep[2]) / Euclidean(ratios[keep[0]], B(keep[2]))
            for ( i in 0..ratios.size-1 ) ratios[i] *= tmp
            ratios[keep[1]] = B(keep[3]) * ratios[keep[0]] / B(keep[2])
            for (i in 1..4) { keep.removeAt(0) }
        }
    }

    var gcd = Euclidean(ratios[0], ratios[1])
    if (ratios.size != 2)
        for (i in 2..ratios.size-1) {
            gcd = Euclidean(gcd, ratios[i])
            if (gcd == B(1)) break
        }
    if (gcd != B(1)) for ( i in 0..ratios.size-1 ) ratios[i] /= gcd

    println(ratios.joinToString(" "))
}