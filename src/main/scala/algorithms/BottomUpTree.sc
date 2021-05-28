/*
It can be considered as a PREORDER traversal.

Algorithm works like the following:
1. return specific value for null node
2. left_ans = bottom_up(root.left)      // call function recursively for left child
3. right_ans = bottom_up(root.right)    // call function recursively for right child
4. return answers                       // answer <-- left_ans, right_ans, root.val


Let's go on discussing the question about maximum depth but using
a different way of thinking: for a single node of the tree,
what will be the maximum depth x of the subtree rooted at itself?

When you meet a tree problem, ask yourself a questions:
  - for a node in a tree, if you know the answer of its children,
  can you calculate the answer of that node?

If the answer is yes, solving the problem recursively
using a bottom up approach might be a good idea.
 */

case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

def maximumDepthSubTree(root: TreeNode): Int = {
  if (root != null) {
    val leftMax = maximumDepthSubTree(root.left)
    val rightMax = maximumDepthSubTree(root.right)

    math.max(leftMax, rightMax) + 1 // return depth of the subtree rooted at root
  } else {
    0
  }
}
