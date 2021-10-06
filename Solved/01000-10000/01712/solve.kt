import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val A = nextInt()
    val B = nextInt()
    val C = nextInt()

    if(B >= C) println("-1")
    else println(A / (C - B) + 1)
}