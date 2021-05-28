/*
It can be considered as a POSTORDER traversal.

Algorithm works like the following:
1. return specific value for null node
2. update the answer if needed                      // answer <-- params
3. left_ans = top_down(root.left, left_params)      // left_params <-- root.val, params
4. right_ans = top_down(root.right, right_params)   // right_params <-- root.val, params
5. return the answer if needed                      // answer <-- left_ans, right_ans

For instance, consider this problem: given a binary tree, find its maximum depth.


When you meet a tree problem, ask yourself two questions:
  - Can you determine some parameters to help the node know its answer?
  - Can you use these parameters and the value of the
  node itself to determine what should be the parameters passed to its children?

If the answers are both yes, try to solve this problem using a "top-down" recursive solution.
 */

case class TreeNode(value: Int, left: TreeNode = null, right: TreeNode = null)

// mutable
def maximumDepth(root: TreeNode): Int = {
  var answer = 0
  def loop(root: TreeNode, maxDepth: Int = 0): Int = {
    if (root != null) {
      if (root.left == null && root.right == null)
        answer = math.max(answer, maxDepth)

      loop(root.left, maxDepth + 1)
      loop(root.right, maxDepth + 1)
    }
  }
  loop(root, 0)
}

def maximumDepthImmutable(root: TreeNode): Int = {
  def loop(root: TreeNode, maxDepth: Int = 0): Int = {
    if (root == null) maxDepth
    else math.max(loop(root.left, maxDepth + 1), loop(root.right, maxDepth + 1))
  }

  loop(root, 0)
}
