import java.util.*
import java.math.BigInteger

fun B(num: Int): BigInteger {
    return num.toBigInteger()
}

fun main() = with(Scanner(System.`in`)) {
    var n = nextInt()

    if(n == 0) println(0)
    else {
        var a = B(0)
        var b = B(1)
        var c = a + b

        while(n-- > 1) {
            c = a + b
            a = b
            b = c
        }

        println(c)
    }
}