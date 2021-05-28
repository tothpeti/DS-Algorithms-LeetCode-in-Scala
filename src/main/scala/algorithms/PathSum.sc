case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def pathSum(root: TreeNode, targetSum: Int): Boolean = {
  if (root == null) false
  else if (root.left == null && root.right == null && targetSum - root.value == 0) true
  else pathSum(root.left, targetSum - root.value) || pathSum(root.right, targetSum - root.value)
}

def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
  (p == null && q == null) ||
    (p != null && q != null && p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))

}

val list = TreeNode(1, TreeNode(2, null, null), TreeNode(3, null, null))
val list2 = TreeNode(1, TreeNode(2, null, null), TreeNode(3, null, null))
isSameTree(list, list2)
