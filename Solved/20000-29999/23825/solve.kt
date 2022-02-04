import java.util.*
import kotlin.math.*

fun main() {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }
    
    println(min(N / 2, M / 2))
}