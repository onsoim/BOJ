import java.util.*

fun Div(R: Int) {
    var d = 36000
    var r = R

    while(d % r != 0) { d = r.also { r = d % r } }

    println(36000 / r)
}

fun main() = with(Scanner(System.`in`)) {
    val R = readLine()!!.replace(".", "").toInt()

    Div(R)
}