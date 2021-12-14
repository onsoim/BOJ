import java.util.*

class Tree {
    data class TreeNode<T>(
        var data: T,
        var left:  TreeNode<T>? = null,
        var right: TreeNode<T>? = null
    )

    var root: TreeNode<Int>? = null
    
    fun add(data: Int) {
        val node = TreeNode(data)

        if (root == null) root = node
        else {
            val search = Stack<TreeNode<Int>>()
            search.push(root)

            search@ while (search.isNotEmpty()) {
                val tmp = search.pop()

                if (tmp.data > data) {
                    if (tmp.left == null) {
                        tmp.left = node
                        break@search
                    }
                    else search.push(tmp.left)
                }
                else {
                    if (tmp.right == null) {
                        tmp.right = node
                        break@search
                    }
                    else search.push(tmp.right)
                }
            }
        }
    }

    fun postOrder(root: TreeNode<Int> = this.root!!) {
        if (root.left != null)  postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        println(root.data)
    }
}

fun main() = with(Scanner(System.`in`)) {
    val tree = Tree()

    var s: String?
    while (readLine().also{ s = it } != null) { tree.add(s!!.toInt()) }

    tree.postOrder()
}