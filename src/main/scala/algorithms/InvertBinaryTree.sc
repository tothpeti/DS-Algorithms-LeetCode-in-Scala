case class Node(value: Int = 0, var left: Node = null, var right: Node = null)

def invertBT(root: Node): Node = {
  if (root != null) {
    val tmp = root.left
    root.left = invertBT(root.right)
    root.right = tmp
  }
  root
}
