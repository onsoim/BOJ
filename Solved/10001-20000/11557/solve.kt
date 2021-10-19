import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()

    while(T-- > 0) {
        var N = readLine()!!.toInt()
        var S = "Korea"
        var L = -1

        while(N-- > 0) {
            val line = readLine()!!.split(" ")
            if(line[1].toInt() > L) {
                S = line[0]
                L = line[1].toInt()
            }
        }

        println(S)
    }
}