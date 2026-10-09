
var city = 0
var opponents = 0
var ties = 1
var turnover = 0
var prev = -1
var cnt = 0

fun chkTurnover(): Boolean {
    if (prev == 1) {
        if ( city > opponents && city - cnt < opponents && cnt > turnover) {
            return true
        }
    }
    else if (prev == 2 && city < opponents && opponents - cnt < city && cnt > turnover) {
        return true
    }

    return false
}

fun main() {
    val N = readLine()!!.toInt()

    repeat(N) {
        var score = readLine()!!.toInt()
        // println(score)

        if (score == 1) city += 1
        else opponents += 1

        if (city == opponents) ties += 1

        if (prev == score) cnt += 1
        else {
            if (chkTurnover()) turnover = cnt

            prev = score
            cnt = 1
        }
    }

    if (chkTurnover()) turnover = cnt

    println("${city} ${opponents}\n${ties}\n${turnover}")
}