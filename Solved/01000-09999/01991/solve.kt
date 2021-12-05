import java.util.*

data class TreeNode<T>(
    var data: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)

class Tree {
    var root: TreeNode<String>? = null

    fun add(data: String, left: String, right: String) {
        val node = TreeNode(
            data,
            if(left == ".") null else TreeNode(left),
            if(right == ".") null else TreeNode(right)
        )

        if (root == null) root = node
        else {
            val search = Stack<TreeNode<String>>()
            search.push(root)

            search@ while (search.isNotEmpty()) {
                val tmp = search.pop()

                if (tmp.left != null) {
                    if (tmp.left!!.data == data) {
                        tmp.left = node
                        break@search
                    }
                    else search.push(tmp.left)
                } 
                if (tmp.right != null) {
                    if (tmp.right!!.data == data) {
                        tmp.right = node
                        break@search
                    }
                    else search.push(tmp.right)
                }
            }
        }
    }

    fun preOrder(root: TreeNode<String> = this.root!!) {
        print(root.data)
        if (root.left != null)  preOrder(root.left!!)
        if (root.right != null) preOrder(root.right!!)
    }

    fun inOrder(root: TreeNode<String> = this.root!!) {
        if (root.left != null)  inOrder(root.left!!)
        print(root.data)
        if (root.right != null) inOrder(root.right!!)
    }

    fun postOrder(root: TreeNode<String> = this.root!!) {
        if (root.left != null)  postOrder(root.left!!)
        if (root.right != null) postOrder(root.right!!)
        print(root.data)
    }
}

fun main() = with(System.`in`.bufferedReader()) {
    val tree = Tree()

    repeat(readLine()!!.toInt()) {
        var (d, l, r) = readLine()!!.split(" ")
        tree.add(d, l, r)
    }

    tree.preOrder()
    println()
    tree.inOrder()
    println()
    tree.postOrder()
}