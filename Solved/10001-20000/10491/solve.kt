import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var s: String?
    val regex = """[P|p]roblem""".toRegex()

    while(readLine().also { s = it } != null) {
        if(regex.find(s.toString().lowercase()) == null) println("no")
        else println("yes")
    }
}