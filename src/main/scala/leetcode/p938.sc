/*
Problem 938: Range Sum of BST

Given the root node of a binary search tree and two integers low and high,
return the sum of values of all nodes with a value in the inclusive range [low, high].
 */

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def rangeSumBST(root: TreeNode, low: Int, high: Int): Int = {
  def dfs(current: TreeNode): Int = {
    if (current == null) 0
    else {
      val tmp = {
        if (current.value >= low && current.value <= high)
          current.value
        else
          0
      }
      tmp + dfs(current.left) + dfs(current.right)
    }
  }
  dfs(root)
}

val nodes =
  TreeNode(10,
    TreeNode(5,
      TreeNode(3), TreeNode(7)),
    TreeNode(15, null, TreeNode(18)))

rangeSumBST(nodes, 7, 15)
