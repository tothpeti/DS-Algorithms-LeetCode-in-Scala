import scala.collection.mutable

/*
Problem 1161: Maximum Level Sum of a Binary Tree

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def maxLevelSum(root: TreeNode): Int = {
  if (root == null) return 0

  val queue = mutable.Queue(root)
  var depth = 0

  val maxSumsByLevel = mutable.Map.empty[Int, Int]

  while (queue.nonEmpty) {
    val queueLength = queue.length
    var tmpSum = 0
    depth += 1

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      tmpSum += popped.value

      if (popped.left != null) {
        queue.enqueue(popped.left)
      }

      if (popped.right != null) {
        queue.enqueue(popped.right)
      }
    }
    maxSumsByLevel += (depth -> tmpSum)
  }
  maxSumsByLevel.maxBy(_._2)._1
}

val nodes =
  TreeNode(989,
    null,
    TreeNode(10250,
      TreeNode(98693),
      TreeNode(-89388,
        null,
        TreeNode(-32127))))

maxLevelSum(nodes)
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/
