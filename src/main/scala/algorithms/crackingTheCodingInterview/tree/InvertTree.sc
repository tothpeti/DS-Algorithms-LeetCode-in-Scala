case class Node(data: Int, var left: Node = null, var right: Node = null)

def invertTree(root: Node): Node = {
  if (root != null) {
    val tmp = root.left
    root.left = invertTree(root.right)
    root.right = invertTree(tmp)
  }

  root
}

val nodes =
    Node(1,
        Node(2,
            Node(3),
            Node(4)),
        Node(5,
            Node(6),
            Node(7)))

invertTree(nodes)
