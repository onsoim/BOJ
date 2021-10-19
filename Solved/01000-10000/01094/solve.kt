import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var X = nextInt()
    var count = 0

    for(i in 0..6) {
        count += X % 2
        X = X shr 1
    }

    println(count)
}