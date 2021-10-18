import java.util.*

// var BC = Array(1001, { i -> Array(1001, { j -> 0 }) })
var BC = Array(1001) { Array(1001) {0} }

fun Binomial_Coefficient(N: Int, K:Int): Int {
    if(K == 0 || N == K) return 1

    if(BC[N][K] == 0) BC[N][K] = (Binomial_Coefficient(N-1, K-1) + Binomial_Coefficient(N-1, K)) % 10007

    return BC[N][K]
}

fun main() = with(Scanner(System.`in`)) {
    val (N, K) = readLine()!!.split(" ").map() { it.toInt() }

    println(Binomial_Coefficient(N, K))
}