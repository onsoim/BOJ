import java.util.*

fun main() = with(Scanner(System.`in`)) {
    var s: String?
    var flag = false
    val regex_bib = """(?<=(\\begin\{thebibliography\}\{))[0-9]*?(?=\})""".toRegex()
    var text = ""
    var bib = ""

    while(readLine().also { s = it } != null) {
        if(flag || regex_bib.find(s!!) != null) {
            flag = true
            bib += s + "\n"
        }
        else { text += s + "\n" }
    }

    val regex_bibitem = """(?<=(\\bibitem\{)).*?(?=\})""".toRegex()
    val bibitems = regex_bibitem.findAll(bib).map{ it.value }.toList()
    
    var cites = """(?<=(\\cite\{)).*?(?=\})""".toRegex().findAll(text).map { it.value }.toList()

    if(cites.equals(bibitems)) { println("Correct") }
    else {
        println("Incorrect")

        println(bib.split("\n")[0])
        while(cites.size != 0) {
            val c = cites.take(1)[0]
            for(l in bib.split("\n")) {
                if(regex_bibitem.find(l)?.value == c) {
                    println(l)
                    break
                }
            }
            cites -= listOf(c)
        }
        println("\\end{thebibliography}")
    }
    
}