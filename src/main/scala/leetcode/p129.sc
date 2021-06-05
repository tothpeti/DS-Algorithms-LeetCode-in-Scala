/*
Problem 129: Sum Root to Leaf Numbers
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def sumNumbers(root: TreeNode): Int = {
  val paths = mutable.ArrayBuffer[Vector[Int]]()

  def dfs(node: TreeNode, path: Vector[Int]): Unit = {
    if (node == null) return

    if (node.left == null && node.right == null) {
      paths += (path :+ node.value)
    }
    dfs(node.left, path :+ node.value)
    dfs(node.right, path :+ node.value)
  }

  dfs(root, Vector.empty[Int])
  paths.map(path => path.mkString("").toInt).sum

}

val nodes =
  TreeNode(4,
    TreeNode(9, TreeNode(5), TreeNode(1)),
    TreeNode(0))

sumNumbers(nodes)
