import java.io.*

fun getPrime(N: Int): List<Int> {
    val prime = arrayListOf<Int>(2)

    var i = 3

    while (i <= N) {
        var j = 3

        var flag = true
        while(j * j <= i) {
            if(i % j == 0) {
                flag = false
                break
            }
            j += 2
        }
        if (flag) prime.add(i)
        i += 2
    }

    return prime
}
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine()!!.toInt()
    val P = getPrime(N)

    var i = 0
    var j = 0
    var sum = P[i]
    var cnt = 0

    while (i <= j) {
        if (sum == N) {
            cnt++
            if (j < P.size - 1) sum += P[++j]
            else break
        }
        else if (sum > N) sum -= P[i++]
        else if (j < P.size - 1) sum += P[++j]
        else break
    }

    println(cnt)
}