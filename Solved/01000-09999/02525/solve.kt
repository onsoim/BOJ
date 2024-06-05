
fun main() {
    var (A, B) = readLine()!!.split(" ").map { it.toInt() }

    B += readLine()!!.toInt()
    A += B / 60

    println("${A % 24} ${B % 60}")
}