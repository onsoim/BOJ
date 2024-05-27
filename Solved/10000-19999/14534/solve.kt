
fun permutation(candidates: MutableList<Char>, solution: MutableList<Char>) {
    if (candidates.lastIndex == -1) {
        println(solution.joinToString(""))
        return
    }

    repeat( candidates.lastIndex + 1) {
        val tmp = candidates[it]
        solution.add(tmp)
        candidates.removeAt(it)

        permutation(candidates, solution)

        solution.removeAt(solution.size - 1)
        candidates.add(it, tmp)
    }
}

fun main() {
    val T = readLine()!!.toInt()
    repeat(T) {
        println("Case # ${it + 1}:")
        
        val str = readLine()!!
        permutation(str.toMutableList(), mutableListOf())
    }
}