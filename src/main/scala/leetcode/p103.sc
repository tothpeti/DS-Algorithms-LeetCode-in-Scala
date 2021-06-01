import scala.collection.mutable

/*
Problem 103: Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and level between).
 */

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def zigzagLevelOrder(root: TreeNode): List[List[Int]] = {
  if (root == null) return List()

  var results = mutable.ArrayBuffer[List[Int]]()
  val queue = mutable.Queue(root)
  var level = 0

  while (queue.nonEmpty) {
    val queueLength = queue.length

    var levelResults = mutable.ListBuffer[Int]()

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      levelResults = levelResults :+ popped.value

      if (popped.left != null) queue.enqueue(popped.left)
      if (popped.right != null) queue.enqueue(popped.right)
    }

    if (level % 2 == 1) levelResults = levelResults.reverse

    level += 1

    results = results :+ levelResults.toList
  }
  results.toList
}

val nodes =
  TreeNode(3,
    TreeNode(9),
    TreeNode(20, TreeNode(15), TreeNode(7)))

zigzagLevelOrder(nodes)
