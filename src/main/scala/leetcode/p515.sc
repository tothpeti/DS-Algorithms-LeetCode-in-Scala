import scala.collection.mutable

/*
Problem 515: Find Largest Value in Each Tree Row

Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 */

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def largestValue(root: TreeNode): List[Int] = {
  if (root == null) return List()

  val queue = mutable.Queue[TreeNode](root)
  var results = mutable.ArrayBuffer[Int]()

  while (queue.nonEmpty) {
    val queueLength = queue.length

    var maxValue = Integer.MIN_VALUE
    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      maxValue = math.max(popped.value, maxValue)

      if (popped.left != null) {
        queue.enqueue(popped.left)
      }

      if (popped.right != null) {
        queue.enqueue(popped.right)
      }

    }
    results = results :+ maxValue
  }
  results.toList
}

val nodes =
  TreeNode(1, TreeNode(3, TreeNode(5), TreeNode(3)), TreeNode(2, TreeNode(0), TreeNode(9)))

largestValue(nodes)
