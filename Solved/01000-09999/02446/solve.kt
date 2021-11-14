import java.util.*

fun star(N: Int, i: Int) {
    for (x in 0 until i) print(" ")
    for (x in 0 until (N - i) * 2 - 1) print("*")
    println()
}

fun main() = with(Scanner(System.`in`)) {
    val N = nextInt()

    for (i in 0 until N) star(N, i)
    for (i in N - 2 downTo 0) star(N, i)
}