

case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

def isSymmetric(root: TreeNode): Boolean = {
  def loop(left: TreeNode, right: TreeNode): Boolean = {
    (left, right) match {
      case (null, null) => true
      case (left, null) => false
      case (null, right) => false
      case (left, right) if left.value != right.value => false
      case (left, right) => loop(left.left, right.right) && loop(left.right, right.left)
    }
  }

  if (root == null) false
  else loop(root.left, root.right)
}
