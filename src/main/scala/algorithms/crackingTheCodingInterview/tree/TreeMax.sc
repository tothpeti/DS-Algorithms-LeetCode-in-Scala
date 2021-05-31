case class Node(data: Int, left: Node = null, right: Node = null)

def treeMax(root: Node): Int = {
  if (root == null) 0
  else {
    val leftMax = treeMax(root.left)
    val rightMax = treeMax(root.right)
    math.max(root.data, math.max(leftMax, rightMax))
  }
}
