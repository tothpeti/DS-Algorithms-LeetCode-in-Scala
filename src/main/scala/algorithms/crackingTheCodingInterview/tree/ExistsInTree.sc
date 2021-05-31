case class Node(data: Int, left: Node = null, right: Node = null)

def existsInTree(root: Node, value: Int): Boolean = {
  if (root == null) false
  else {
    val inLeft = existsInTree(root.left, value)
    val inRight = existsInTree(root.right, value)
    root.data == value || inLeft || inRight
  }
}
