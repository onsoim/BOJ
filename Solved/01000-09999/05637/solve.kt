import java.util.*
import kotlin.system.exitProcess

fun main() = with(Scanner(System.`in`)) {
    var s: String?
    val regex = """[a-zA-Z-]*""".toRegex()

    var word = ""
    var length = 0

    while(readLine().also { s = it } != null) {
        for(i in regex.findAll(s!!).map{ it.value }) {
            val tmp = i.length

            if (i == "E-N-D") {
                println(word.lowercase())
                exitProcess(0)
            }
            else if (tmp > length) {
                word = i
                length = tmp
            }
        }
    }
}