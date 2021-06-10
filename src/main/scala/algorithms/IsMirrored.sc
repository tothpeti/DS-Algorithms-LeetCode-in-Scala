case class Node(value: Int = 0, left: Node = null, right: Node = null)

def isMirrored(root1: Node, root2: Node): Boolean = {
  (root1, root2) match {
    case (null, null)  => true
    case (null, _)     => false
    case (_, null)     => false
    case (first, second) => first.value == second.value &&
      isMirrored(first.left, second.right) && isMirrored(first.right, second.left)
  }
}

val nodes =
  Node(1,
    Node(2, Node(3), Node(4)),
    Node(5, Node(6), Node(7)))

val nodes1 =
  Node(1,
    Node(5, Node(6), Node(6)),
    Node(2, Node(3), Node(4)))

isMirrored(nodes, nodes1)
