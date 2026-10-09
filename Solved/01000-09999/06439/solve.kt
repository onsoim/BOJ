

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

fun checkIntersect(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int, x4: Int, y4: Int): Boolean {
    val ccw12 = CCW(x1, y1, x2, y2, x3, y3) * CCW(x1, y1, x2, y2, x4, y4)
    val ccw21 = CCW(x3, y3, x4, y4, x1, y1) * CCW(x3, y3, x4, y4, x2, y2)

    if (ccw12 == BigInteger("0") && ccw21 == BigInteger("0")) {
        return (
            if (checkOverlap( x1, x2, x3, x4 ) && 
                checkOverlap( y1, y2, y3, y4 )) 
                    true
            else false
        )
    }
    else return (if (ccw12 <= BigInteger("0") && ccw21 <= BigInteger("0")) true else false)
}

fun main() {
    val N = readLine()!!.toInt()

    repeat(N) {
        val line = readLine()!!.split(" ").map{ it.toInt() }

        var x1 = line[4]
        var x2 = line[6]
        if (x1 > x2) {
            x1 = line[6]
            x2 = line[4]
        }

        var y1 = line[5]
        var y2 = line[7]
        if (y1 > y2) {
            y1 = line[7]
            y2 = line[5]
        }

        println( if ( (
            line[0] >= x1 && line[0] <= x2 && 
            line[1] >= y1 && line[1] <= y2
        ) || (
            line[2] >= x1 && line[2] <= x2 && 
            line[3] >= y1 && line[3] <= y2
        ) ||
        checkIntersect(
            line[0], line[1], line[2], line[3],
            x1, y1, x1, y2 
        ) || 
        checkIntersect(
            line[0], line[1], line[2], line[3],
            x1, y1, x2, y1
        ) ||
        checkIntersect(
            line[0], line[1], line[2], line[3],
            x1, y2, x2, y2
        ) ||
        checkIntersect(
            line[0], line[1], line[2], line[3],
            x2, y1, x2, y2
        )
        ) "T" else "F")
    }
}