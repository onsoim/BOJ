import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var N = readLine()!!.toInt()
    val regex = "^${readLine()!!}$".replace("*", ".*").toRegex()

    while(N-- > 0) {
        if(regex.find(readLine()!!) == null) println("NE")
        else println("DA")
    }
}