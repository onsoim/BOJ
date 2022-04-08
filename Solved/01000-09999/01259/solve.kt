import java.io.*

fun isPalindrome(word: String): Boolean {
    var i = 0
    var j = word.length - 1

    while (i < j) if (word[i++] != word[j--]) return false

    return true
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val word = readLine()!!
        if (word == "0") break

        println(if(isPalindrome(word)) "yes" else "no")
    }
}