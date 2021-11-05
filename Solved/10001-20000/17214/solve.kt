import java.util.*

fun main() = with(Scanner(System.`in`)) {
    val fx = readLine()!!.split("x")

    if (fx.size == 2) {
        var s = ""

        if (fx[0] == "2") s += ""
        else if (fx[0] == "-2") s += "-"
        else s += "${fx[0].toInt()/2}"
        s += "xx"

        if (fx[1] == "+1") s += "+x+"
        else if (fx[1] == "-1") s += "-x+"
        else if (fx[1] != "" && fx[1].toInt() != 0) s += "${fx[1]}x+"
        else s+= "+"

        print(s)
    }
    else if (fx[0] == "1")  print("x+")
    else if (fx[0] == "-1") print("-x+")
    else if (fx[0] != "0")  print("${fx[0]}x+")

    println("W")
}