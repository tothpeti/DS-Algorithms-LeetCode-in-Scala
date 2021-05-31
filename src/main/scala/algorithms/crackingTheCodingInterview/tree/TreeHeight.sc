case class Node(data: Int, left: Node, right: Node)

def treeHeight(root: Node): Int = {
  if (root == null) 0
  else {
    val leftHeight = treeHeight(root.left)
    val rightHeight = treeHeight(root.right)
    1 + math.max(leftHeight, rightHeight)
  }
}
