import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var T = readLine()!!.toInt()

    while(T-- > 0) {
        var representation = "^${readLine()!!}$"
        val output = readLine()!!
        var regex = """${representation}""".toRegex()

        if(regex.findAll(output).count() != 0) println("_")
        else {
            var FSM = '_'

            for (i in 'A'..'Z') {
                regex = """${representation.replace('_', i)}""".toRegex()
                if(regex.findAll(output).count() != 0) FSM = i
            }

            if (FSM == '_') println("!")
            else println(FSM)
        }
    }
}