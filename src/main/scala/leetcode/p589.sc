/*
Problem 589: N-ary Tree Preorder Traversal
 */
case class Node(value: Int = 0, children: List[Node] = List())

def preorder(root: Node): List[Int] = {
  if (root == null) return List()

  root.value +: root.children.flatMap(preorder)
}
