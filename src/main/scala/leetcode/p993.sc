import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def isCousins(root: TreeNode, x: Int, y: Int): Boolean = {
  if (root == null) return false

  // node, parent, depth
  val queue = mutable.Queue[(TreeNode, TreeNode, Int)]((root, null, 0))

  // parent, depth
  var potentialCousins = new ArrayBuffer[(TreeNode, Int)]()
  var stop = false

  while(queue.nonEmpty && !stop) {

    val (current, parent, depth) = queue.dequeue()

    if (current.value == x || current.value == y)
      potentialCousins = potentialCousins :+ (parent, depth)

    if (current.left != null) queue.enqueue((current.left, current , depth + 1))

    if (current.right != null) queue.enqueue((current.right, current, depth + 1))

    if (potentialCousins.length == 2) stop = true
  }

  if (potentialCousins.nonEmpty &&
    potentialCousins(0)._1 != potentialCousins(1)._1 &&
    potentialCousins(0)._2 == potentialCousins(1)._2) {
    true
  } else {
    false
  }
}

val nodes =
  TreeNode(1,
    TreeNode(2, TreeNode(4)),
    TreeNode(3, TreeNode(5))
)

isCousins(nodes, 5, 4)
