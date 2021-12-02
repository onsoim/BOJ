import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val c = readLine()!!.split("x")

    if (c.size == 2) {
        if (c[0] == "") println("1")
        else if (c[0] == "-") println("-1")
        else println(c[0])
    }
    else println("0")
}