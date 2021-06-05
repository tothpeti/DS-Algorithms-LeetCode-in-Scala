/*
Problem 114: Flatten Binary Tree to Linked List
 */
class TreeNode(value: Int = 0, var left: TreeNode = null, var right: TreeNode = null)

var prev: TreeNode = null

def flatten(root: TreeNode): Unit = {
  if (root == null) return

  flatten(root.left)
  flatten(root.right)

  root.left = null
  root.right = prev
  prev = root
}
