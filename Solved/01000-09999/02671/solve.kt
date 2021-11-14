import java.util.*

fun main() = with(Scanner(System.`in`)) {
    if("""^(100+1+|01)+$""".toRegex().find(readLine()!!) != null) println("SUBMARINE")
    else println("NOISE")
}