import java.util.*
import java.math.BigInteger

fun B(num: Int): BigInteger {
    return num.toBigInteger()
}

fun main() = with(Scanner(System.`in`)) {
    var N = nextInt()

    while(N-- > 0) {
        val K = nextBigInteger()

        if(K % B(2) == B(0)) println("even")
        else println("odd")
    }
}