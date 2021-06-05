/*
Problem 404: Sum of Left Leaves
 */

import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def sumOfLeftLeaves(root: TreeNode): Int = {
  if (root == null)
    return 0

  if (root != null && root.left == null && root.right == null)
    return 0

  val leftLeaves = mutable.ArrayBuffer[Int]()

  // (node, isLeft)
  val queue = mutable.Queue[(TreeNode, Boolean)]((root, false))

  while (queue.nonEmpty) {
    val queueLength = queue.length

    for (idx <- 0 until queueLength) {
      val (node, status) = queue.dequeue()


      if (node.left != null) queue.enqueue((node.left, true))
      if (node.right != null) queue.enqueue((node.right, false))

      if (status && (node.left == null && node.right == null))
        leftLeaves += node.value
    }
  }

  leftLeaves.sum
}
