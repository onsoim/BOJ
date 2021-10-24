import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()
    val regex_Vega = """^(100+1+|01)+$""".toRegex()

    while(T-- > 0) {
        val N = readLine()!!
        if(regex_Vega.find(N) != null ) println("YES")
        else println("NO")
    }
}