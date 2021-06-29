case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def isBalanced(root: TreeNode): Boolean = {
  def dfs(current: TreeNode): Int = {
    if (current == null) 0
    else {
      val leftHeight = dfs(current.left)
      val rightHeight = dfs(current.right)

      1 + math.max(leftHeight, rightHeight)
    }
  }

  if (root == null) return true

  val diff = math.abs(dfs(root.left) - dfs(root.right))

  if (diff <= 1 && isBalanced(root.left) && isBalanced(root.right))
    true
  else
    false
}

val nodes = TreeNode(1, TreeNode(2, TreeNode(3)))
isBalanced(nodes)