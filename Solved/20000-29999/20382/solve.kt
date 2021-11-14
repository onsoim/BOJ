import java.util.*


fun get_Month(Month: String): Int {
    if (Month == "January")   return 1
    if (Month == "February")  return 2
    if (Month == "March")     return 3
    if (Month == "April")     return 4
    if (Month == "May")       return 5
    if (Month == "June")      return 6
    if (Month == "July")      return 7
    if (Month == "August")    return 8
    if (Month == "September") return 9
    if (Month == "October")   return 10
    if (Month == "November")  return 11
    return 12
}

fun get_Start(Start: String): Int {
    val l = Start.length
    var start = 0

    start += Start.split(":")[0].toInt() * 2
    if (start == 24) start -= 24
    if (Start.substring(l-4, l-3) == "3") start += 1
    if (Start.substring(l-2, l) == "pm") start += 24

    return start
}

fun main() = with(Scanner(System.`in`)) {
    var s: String?

    while (readLine().also { s = it } != null ) {
        val comp = s!!.split(" ")

        println(
            // Channel
            comp[1].substring(0, comp[1].length - 1).toBigInteger().shl(19) + 
            // Month
            get_Month(comp[2]).toBigInteger().shl(15) + 
            // Day
            comp[3].toBigInteger().shl(10) + 
            // Year
            (comp[4].substring(0, comp[4].length - 1).toInt() - 1994).toBigInteger().shl(25) + 
            // Start
            get_Start(comp[5]).toBigInteger().shl(4) + 
            // Length
            comp[6].substring(0, comp[6].length - 3).toBigInteger() / 30.toBigInteger()
        )
    }
}