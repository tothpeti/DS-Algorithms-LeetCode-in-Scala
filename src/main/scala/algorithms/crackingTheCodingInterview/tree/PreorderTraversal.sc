case class Node(value: Int = 0, left: Node = null, right: Node = null)

def preOrder(root: Node): Unit = {
  def dfs(current: Node): Unit = {
    if (current == null) null
    else {
      println(current.value)
      if (current.left != null)
        dfs(current.left)

      if (current.right != null)
        dfs(current.right)
    }
  }
  dfs(root)
}

val nodes =
  Node(1,
    Node(2,
      Node(4), Node(5)),
    Node(3, Node(6)))

preOrder(nodes)
