import scala.collection.mutable

/*
Problem 513: Find Bottom Left Tree Value

Given the root of a binary tree, return the leftmost value in the last row of the tree.
 */
case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def findBottomLeftValue(root: TreeNode): Int = {
  if (root == null) return 0

  val queue = mutable.Queue[TreeNode](root)

  var result = 0
  while (queue.nonEmpty) {
    val queueLength = queue.length

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      if (i == 0) result = popped.value

      if (popped.left != null) queue.enqueue(popped.left)

      if (popped.right != null) queue.enqueue(popped.right)
    }
  }
  result
}


val nodes =
  TreeNode(0,
    TreeNode(2), TreeNode(-1))
findBottomLeftValue(nodes)
