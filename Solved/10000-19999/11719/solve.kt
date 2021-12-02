import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var s: String?

    while(readLine().also { s = it } != null) { println(s) }
}