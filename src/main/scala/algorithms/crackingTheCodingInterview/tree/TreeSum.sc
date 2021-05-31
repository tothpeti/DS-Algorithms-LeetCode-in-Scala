case class Node(data: Int, left: Node = null, right: Node = null)

def treeSum(root: Node): Int = {
  if (root == null) 0
  else {
    val leftSum = treeSum(root.left)
    val rightSum = treeSum(root.right)
    root.data + leftSum + rightSum
  }
}
