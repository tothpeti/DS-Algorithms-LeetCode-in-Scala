import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def deepestLeavesSum(root: TreeNode): Int = {
  if (root == null) return 0

  var queue = mutable.Queue[TreeNode](root)
  var levels = mutable.ArrayBuffer[mutable.ArrayBuffer[Int]]()

  while (queue.nonEmpty) {
    var queueLength = queue.length

    var currentLevelNodes = mutable.ArrayBuffer[Int]()
    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      if (popped.left != null) queue.enqueue(popped.left)
      if (popped.right != null) queue.enqueue(popped.right)

      if (popped.left == null && popped.right == null)
        currentLevelNodes = currentLevelNodes :+ popped.value
    }
    levels = levels :+ currentLevelNodes
  }

  if (levels.nonEmpty)
    levels.last.sum
  else
    0
}

val nodes =
  TreeNode(1, TreeNode(2), TreeNode(3))

deepestLeavesSum(nodes)