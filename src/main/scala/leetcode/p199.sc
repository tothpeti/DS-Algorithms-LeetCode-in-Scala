/*
Problem 119: Binary Tree Right Side View
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def rightSideView(root: TreeNode): List[Int] = {
  val rightNodes = mutable.ArrayBuffer[Int]()

  def dfs(node: TreeNode, level: Int): Unit = {
    if (node == null) return
    if (rightNodes.length == level)
      rightNodes += node.value

    dfs(node.right, level + 1)
    dfs(node.left, level + 1)
  }

  dfs(root, 0)
  rightNodes.toList
}

val nodes =
  TreeNode(1,
    TreeNode(2, null, TreeNode(5)),
    TreeNode(3, null, TreeNode(4)))

rightSideView(nodes)
