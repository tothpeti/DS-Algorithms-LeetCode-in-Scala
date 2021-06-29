import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, var right: TreeNode = null)

def leafSimilar(root1: TreeNode, root2: TreeNode): Boolean = {

  def rec(current: TreeNode): Array[Int] = {
    var res = mutable.ArrayBuffer[Int]()

    if (current == null) return res.toArray
    else if (current.left == null && current.right == null)
      res = res :+ current.value
    else {
      if (current.left != null) res = res ++ rec(current.left)
      if (current.right != null) res = res ++ rec(current.right)
    }
    res.toArray
  }
  val first = rec(root1)
  val second = rec(root2)

  first.sameElements(second)
}

val nodes =
  TreeNode(5, TreeNode(1), TreeNode(7))

leafSimilar(nodes, nodes)