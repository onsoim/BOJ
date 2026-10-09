
import java.math.BigInteger


// counter clockwise
// Fail case : overflow
fun CCW(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): BigInteger {
    return BigInteger("${x2 - x1}") * BigInteger("${y3 - y1}") - BigInteger("${x3 - x1}") * BigInteger("${y2 - y1}")
}

fun main() {
    val line = readLine()!!.split(" ").map{ it.toInt() }

    val ccw12 = CCW(line[0], line[1], line[2], line[3], line[4], line[5]) * CCW(line[0], line[1], line[2], line[3], line[6], line[7])
    val ccw21 = CCW(line[4], line[5], line[6], line[7], line[0], line[1]) * CCW(line[4], line[5], line[6], line[7], line[2], line[3])

    println(if (ccw12 < BigInteger("0") && ccw21 < BigInteger("0")) 1 else 0)
}