import java.util.*

fun star(buffer: Array<ArrayList<String>>, start: Int, n: Int) {
    if (n == 3) {
        buffer[start]     += "***"
        buffer[start + 1] += "* *"
        buffer[start + 2] += "***"
    }
    else {
        star(buffer, start + 0, n / 3)
        star(buffer, start + n / 3, n / 3)
        star(buffer, start + n * 2 / 3, n / 3)

        star(buffer, start + 0, n / 3)
        repeat(n / 3) { i -> buffer[start + n / 3 + i] += " ".repeat(n / 3) }
        star(buffer, start + n * 2 / 3, n / 3)
        
        star(buffer, start + 0, n / 3)
        star(buffer, start + n / 3, n / 3)
        star(buffer, start + n * 2 / 3, n / 3)
    }
}

fun main() {
    val N = readLine()!!.toInt()
    val buffer = Array(N) { arrayListOf<String>() }
    star(buffer, 0, N)
    
    buffer.forEach { println(it.joinToString("")) }
}