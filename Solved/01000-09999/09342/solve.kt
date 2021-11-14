import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()
    val regex = """^[A-F]?A+F+C+[A-F]?$""".toRegex()

    while(T-- > 0) {
        if(regex.findAll(readLine()!!).count() == 0)
            println("Good")
        else println("Infected!")
    }
}