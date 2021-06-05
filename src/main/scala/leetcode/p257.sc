/*
Problem 257: Binary Tree Paths
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def binaryTreePaths(root: TreeNode): List[String] = {
  val paths = mutable.ArrayBuffer[Vector[String]]()

  def dfs(node: TreeNode, path: Vector[String]): Unit = {
    if (node == null) return
    if (node.left == null && node.right == null)
      paths += (path :+ node.value.toString)

    dfs(node.left, path :+ node.value.toString)
    dfs(node.right, path :+ node.value.toString)
  }

  dfs(root, Vector.empty[String])

  paths.map(path => path.mkString("->")).toList
}

val nodes =
  TreeNode(1,
    TreeNode(2, null, TreeNode(5)),
    TreeNode(3))

val nodes1 = TreeNode(1)
binaryTreePaths(nodes1)
