import java.util.*

fun is_prime(N: Int): Boolean {
    var i = 3

    if(N == 1) return false
    while(i * i <= N) {
        if(N % i == 0) return false
        i += 2
    }

    return true
}

fun main() = with(Scanner(System.`in`)) {
    var M = nextInt()
    val N = nextInt()

    var sum = 0
    var p = 0

    if((M == 1) and (M < N)) M += 1
    if(M == 2) {
        sum += 2
        p = 2
    }

    if(M % 2 == 0) M += 1
    for(i in M..N step 2) {
        if(is_prime(i)) {
            sum += i
            if(p == 0) p = i
        }
    }

    if(sum == 0) println("-1")
    else println("$sum\n$p")
}