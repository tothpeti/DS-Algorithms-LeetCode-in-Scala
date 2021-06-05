/*
Problem 107: Binary Tree Level Order Traversal II
 */
import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def levelOrderBottom(root: TreeNode): List[List[Int]] = {
  if (root == null) return List()

  val levels = mutable.ArrayBuffer[List[Int]]()

  val queue = mutable.Queue[TreeNode](root)

  while (queue.nonEmpty) {
    val queueLength = queue.length

    val tmpLevels = mutable.ArrayBuffer[Int]()

    for (_ <- 0 until queueLength) {
      val node = queue.dequeue()

      tmpLevels += node.value

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)
    }

    levels += tmpLevels.toList
  }

  if (levels.nonEmpty) levels.reverse.toList
  else levels.toList
}
