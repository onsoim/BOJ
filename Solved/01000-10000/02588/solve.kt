import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val A = nextInt()
    val B = nextInt()

    println( A * ( B % 10 ) )
    println( A * ( B / 10 % 10 ) )
    println( A * ( B / 100 ) )
    println( A * B )
}