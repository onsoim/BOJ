import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var N = readLine()!!.toCharArray()
    val l = N.size

    for(i in 0 until l - 1) {
        for(j in i + 1 until l) {
            if(N[i] < N[j])
                N[i] = N[j].also { N[j] = N[i] }
        }
    }
    println(N)
}