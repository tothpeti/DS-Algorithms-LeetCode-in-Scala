/*
Problem 113: Path Sum II
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def pathSum(root: TreeNode, targetSum: Int): List[List[Int]] = {
  val paths = mutable.ArrayBuffer[List[Int]]()

  def dfs(node: TreeNode, sum: Int, path: List[Int]): Unit = {
    if (node == null) return
    if (node.left == null && node.right == null && sum - node.value == 0)
      paths += (path :+ node.value)

    dfs(node.left, sum - node.value, path :+ node.value)
    dfs(node.right, sum - node.value, path :+ node.value)
  }

  dfs(root, targetSum, List.empty[Int])

  paths.toList
}

val nodes =
  TreeNode(1,
    TreeNode(2),
    TreeNode(3))

pathSum(nodes, 3)
