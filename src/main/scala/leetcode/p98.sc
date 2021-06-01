/*
Problem 98: Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 */


case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

def isValidBST(root: TreeNode): Boolean = {
  def isValid(root: TreeNode, min: TreeNode, max: TreeNode): Boolean = {
    if (root == null) return true
    if (min != null && root.value <= min.value) return false
    if (max != null && root.value >= max.value) return false

    isValid(root.left, min, root) && isValid(root.right, root, max)
  }
  isValid(root, null, null)
}

val nodes =
  TreeNode(5,
    TreeNode(4, TreeNode(3)))

isValidBST(nodes)
