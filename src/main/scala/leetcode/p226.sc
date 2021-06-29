case class TreeNode(value: Int = 0, var left: TreeNode = null, var right: TreeNode = null)

def invertBinaryTree(root: TreeNode): TreeNode = {
  if (root == null) return root

  var left = invertBinaryTree(root.left)
  var right = invertBinaryTree(root.right)

  var tmp: TreeNode = null
  tmp = left
  left = right
  right = left

  root.left = left
  root.right = right

  root
}