case class Node(value: Int = 0, var left: Node = null, var right: Node = null)

def insertBST(root: Node, value: Int): Node = {
  def insert(node: Node): Node = {
    if (node == null) return Node(value)
    else if(node.value < value) node.right = insert(node.right)
    else node.left = insert(node.left)

    node
  }

  insert(root)
}
