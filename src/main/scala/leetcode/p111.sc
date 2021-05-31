import scala.collection.mutable

/*
Problem 111: Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
 */

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def minimumDepth(root: TreeNode): Int = {
  if (root == null) return 0

  val queue = mutable.Queue(root)
  var minDepth = 1

  while (queue.nonEmpty) {
    val queueLength = queue.length

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      if (popped.left == null && popped.right == null)
        return minDepth

      if (popped.left != null) queue.enqueue(popped.left)

      if (popped.right != null) queue.enqueue(popped.right)
    }
    minDepth += 1
  }
  minDepth
}

val nodes =
  TreeNode(1,
    TreeNode(2,
      TreeNode(3)
    ),
    TreeNode(5,
      TreeNode(6),
      TreeNode(7,
        TreeNode(8))))

val nodes = TreeNode()
minimumDepth(nodes)
