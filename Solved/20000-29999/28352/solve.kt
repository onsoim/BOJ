
fun main() {
    val N = readLine()!!.toInt()

    var weeks = 6
    repeat (N - 10) { weeks *= ( it + 11 ) }

    println(weeks)
}