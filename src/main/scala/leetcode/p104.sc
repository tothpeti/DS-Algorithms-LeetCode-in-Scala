case class Node(value: Int = 0, left: Node = null, right: Node = null)

def maxDepth(root: Node): Int = {
  def dfs(node: Node): Int = {
    if (root == null) return 0

    1 + math.max(dfs(root.left), dfs(root.right))
  }
  dfs(root)
}