import java.util.*


fun check_Slimp(s: String): Boolean {
    if (s[0] == 'A') {
        var is_Slimp = s.substring(1, s.length)

        if(is_Slimp == "H") return true
        else {
            if(is_Slimp[is_Slimp.length - 1] == 'C') {
                is_Slimp = is_Slimp.substring(0, is_Slimp.length - 1)

                return if(is_Slimp[0] == 'B') {
                    is_Slimp = is_Slimp.substring(1, is_Slimp.length)
                    check_Slimp(is_Slimp)
                }
                else { """^((D|E)F+)+G$""".toRegex().find(is_Slimp) != null }
            }
        }
    }

    return false
}

fun check_Slurpy(s: String): Boolean {
    val regex_Slump = """((D|E)F+)+G$""".toRegex()

    if(regex_Slump.find(s) != null) {
        val is_Slimp = s.substring(0, s.length - regex_Slump.find(s)!!.value.length)
        return if(is_Slimp != "") { check_Slimp(is_Slimp) } else { false }
    }
    return false
}

fun main() = with(Scanner(System.`in`)) {
    var N = readLine()!!.toInt()

    println("SLURPYS OUTPUT")
    while(N-- > 0) {
        if(check_Slurpy(readLine()!!)) println("YES")
        else println("NO")
    }
    println("END OF OUTPUT")
}