
fun main() {
    val (x, y, z) = readLine()!!.split(" ").map{ it.toInt() }
    var score = x
    if (y > score) score = y
    if (z > score) score = z

    if (x == y) {
        score = 10 + x
        if (y == z) score *= 10
    }
    else if (y == z || x == z) {
        score = 10 + z
    }

    println(score * 100)
}