
import java.math.BigInteger


fun checkOverlap(x1: Int, x2: Int, x3: Int, x4: Int): Boolean {
    var p1 = x1
    var p2 = x2
    if (p1 > p2) {
        p1 = x2
        p2 = x1
    }

    var p3 = x3
    var p4 = x4
    if (p3 > p4) {
        p3 = x4
        p4 = x3
    }

    return p1 <= p4 && p2 >= p3
}

// counter clockwise
// Fail case : overflow
fun CCW(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): BigInteger {
    return BigInteger("${x2 - x1}") * BigInteger("${y3 - y1}") - BigInteger("${x3 - x1}") * BigInteger("${y2 - y1}")
}

fun main() {
    val line1 = readLine()!!.split(" ").map{ it.toInt() }
    val line2 = readLine()!!.split(" ").map{ it.toInt() }
    
    val ccw12 = CCW(line1[0], line1[1], line1[2], line1[3], line2[0], line2[1]) * CCW(line1[0], line1[1], line1[2], line1[3], line2[2], line2[3])
    val ccw21 = CCW(line2[0], line2[1], line2[2], line2[3], line1[0], line1[1]) * CCW(line2[0], line2[1], line2[2], line2[3], line1[2], line1[3])

    if (ccw12 == BigInteger("0") && ccw21 == BigInteger("0")) {
        println(
            if (checkOverlap( line1[0], line1[2], line2[0], line2[2] ) && 
                checkOverlap( line1[1], line1[3], line2[1], line2[3] )) 
                    1
            else 0
        )
    }
    else println(if (ccw12 <= BigInteger("0") && ccw21 <= BigInteger("0")) 1 else 0)
}