
fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b

    while (num1 != 0 && num2 != 0) {
        if (num1 > num2) num1 -= num2 * (num1 / num2)
        else num2 -= num1 * (num2 / num1)
    }

    return if (num1 == 0) num2 else num1
}

fun main() {
    var N = readLine()!!.toInt()
    var idx = 0
    
    do {
        idx += 1
        var numerator = 0
        var denominator = 1
        var natural = 0

        repeat(N) {
            val frac = readLine()!!.split(",", "/").map{ it.toInt() }
            var num = 0
            var den = 1

            when (frac.size) {
                3 -> {
                    natural += frac[0]
                    num = frac[1]
                    den = frac[2]
                }
                2 -> {
                    num = frac[0]
                    den = frac[1]
                }
                1 -> {
                    natural += frac[0]
                }
            }

            var gcd_nd = gcd(num, den)
            if (gcd_nd != 1) {
                num /= gcd_nd
                den /= gcd_nd
            }
            numerator = denominator * num + numerator * den
            denominator *= den

            gcd_nd = gcd(numerator, denominator)
            if (gcd_nd != 1) {
                numerator /= gcd_nd
                denominator /= gcd_nd
            }

            val cnt = numerator / denominator
            if (cnt > 0) {
                natural += cnt
                numerator %= denominator
            }
        }

        print("Test $idx: ")
        if (natural == 0) {
            if (numerator == 0) println(0)
            else println(if (denominator == 1) numerator else "$numerator/$denominator")
        }
        else {
            print(natural)
            if (numerator > 0) {
                print(",")
                print(if (denominator == 1) numerator else "$numerator/$denominator")
            }
            println()
        }

        N = readLine()!!.toInt()
    } while (N != 0)
}