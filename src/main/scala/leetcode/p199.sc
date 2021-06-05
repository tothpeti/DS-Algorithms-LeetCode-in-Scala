/*
Problem 119: Binary Tree Right Side View
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

// DFS approach
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

// BFS approach
def rightSideView2(root: TreeNode): List[Int] = {
  if (root == null) return List()

  val levels = mutable.ArrayBuffer[Int]()
  val queue = mutable.Queue[TreeNode](root)

  while (queue.nonEmpty) {
    val queueLength = queue.length

    for (i <- 0 until queueLength) {
      val node = queue.dequeue()

      if (i == queueLength - 1) levels += node.value

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)
    }
  }
  levels.toList
}

val nodes =
  TreeNode(1,
    TreeNode(2, null, TreeNode(5)),
    TreeNode(3, null, TreeNode(4)))

rightSideView(nodes)
rightSideView2(nodes)
