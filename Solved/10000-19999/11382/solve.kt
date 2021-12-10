import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()) {
    var sum = BigInteger.ZERO

    readLine()!!.split(" ").map { 
        sum += it.toBigInteger()
    }

    println(sum)
}