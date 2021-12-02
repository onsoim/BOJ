import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var (A, B, N) = readLine()!!.split(" ").map { it.toInt() }
    var n = 0

    A %= B
    while(N > 0) {
        A *= 10
        n = A / B
        A %= B
        if(A == 0) break
        N--
    }

    println(n)
}