
fun main() {
    val N = readLine()!!.toInt()
    val sentences = readLine()!!.split(".", "?", "!").map{ it.trim() }

    repeat(N) {
        var cnt = 0

        for (word in sentences[it].split(" ")) {
            if (word[0] >= 'A' && word[0] <= 'Z') {
                cnt += 1
                for (i in 1 until word.length) {
                    if (word[i] < 'a' || word[i] > 'z') {
                        cnt -= 1
                        break
                    }
                }
            }
        }

        println(cnt)
    }
}