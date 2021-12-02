import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val l = readLine()!!.split(" ").map { it.toInt() }
    var A = 0
    var index = 0
    var sum = 0

    for (i in 1 until 50){
        for (j in 0 until i) {
            index += 1
            sum += i

            if(index == l[0] - 1) A = sum
            else if(index == l[1]) {
                println( sum - A )
                return
            }
        }
    }
}