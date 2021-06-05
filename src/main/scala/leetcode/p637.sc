import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def averageOfLevels(root: TreeNode): Array[Double] = {
  if (root == null) return Array()

  val levels = mutable.ArrayBuffer[Double]()
  val queue = mutable.Queue[TreeNode](root)

  while (queue.nonEmpty) {
    val queueLength = queue.length

    var sum: Double = 0

    for (_ <- 0 until queueLength) {
      val node = queue.dequeue()

      sum += node.value

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)
    }

    levels += (sum / queueLength)
  }

  if (levels.nonEmpty) levels.toArray
  else Array()
}

val nodes =
  TreeNode(2147483647,
    TreeNode(2147483647),
    TreeNode(2147483647))

averageOfLevels(nodes)
