import java.util.*

fun get_Month(Month: String): Int {
    if (Month == "Jan") return 1
    if (Month == "Feb") return 2
    if (Month == "Mar") return 3
    if (Month == "Apr") return 4
    if (Month == "May") return 5
    if (Month == "Jun") return 6
    if (Month == "Jul") return 7
    if (Month == "Aug") return 8
    if (Month == "Sept")return 9
    if (Month == "Oct") return 10
    if (Month == "Nov") return 11
    return 12
}

fun main() = with(Scanner(System.`in`)) {
    val time = Calendar.getInstance().time.toString().split(" ")
    println("${time[5]}-${get_Month(time[1])}-${time[2]}")
}