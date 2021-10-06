import java.util.*
import java.math.BigInteger

fun main() = with(Scanner(System.`in`)) {
    val n = nextInt()
    val m = nextInt()
    var c = BigInteger.ONE

    for (i in 1 until m + 1) {
        c *= BigInteger.valueOf((n - i + 1).toLong())
        c /= BigInteger.valueOf(i.toLong())
    }

    println(c)
}