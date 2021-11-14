import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var idx = 0
    var cnt = 0

    // val cnt = regex.findAll(CMDs).count()
    for(i in """[A-Z]""".toRegex().findAll(readLine()!!).map{ it.range.start }.toList()) {
        if(i != 0) {
            // Don't forget result of modular could be negative
            cnt += (idx - i + 200) % 4
            idx = i
        }
    }

    println(cnt)
}