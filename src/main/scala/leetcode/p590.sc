/*
Problem 590: N-ary Tree Postorder Traversal
 */
case class Node(value: Int = 0, children: List[Node] = List())

def postorder(root: Node): List[Int] = {
  if (root == null) return List()

  root.children.flatMap(postorder) :+ root.value
}
