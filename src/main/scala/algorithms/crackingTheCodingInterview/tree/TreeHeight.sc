case class Node(value: Int = 0, left: Node = null, right: Node = null)

def treeHeight(root: Node): Int = {
  if (root == null) 0
  else {
    val leftHeight = treeHeight(root.left)
    val rightHeight = treeHeight(root.right)

    1 + math.max(leftHeight, rightHeight)
  }
}
val nodes =
    Node(1,
        Node(2,
            Node(4), Node(5)),
        Node(3, Node(6)))

treeHeight(nodes)
