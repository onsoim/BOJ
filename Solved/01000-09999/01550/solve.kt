import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var D = 0

    val H = readLine()!!.toCharArray()
    for (i in H.indices) {
        var d = H[i].code
        if(d > 64) d -= 55
        else d -= 48

        D = D * 16 + d
    }
    println(D)
}