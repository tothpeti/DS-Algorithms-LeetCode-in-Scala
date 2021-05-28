

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

// normal level order BFS
def normalLevelOrderBfs(root: TreeNode): List[Int] = {
  val queue = mutable.Queue[TreeNode]()
  queue += root

  val visited = mutable.ArrayBuffer[Int]()
  while (queue.nonEmpty) {
    val current = queue.dequeue()
    visited += current.value

    if (current.left != null) queue.enqueue(current.left)
    else if (current.right != null) queue.enqueue(current.right)
  }
  visited.toList
}

def bfs(root: TreeNode): List[List[Int]] = {
  val visited = mutable.Map[Int, List[Int]]()

  def loop(root: TreeNode, depth: Int = 0): Unit = {
    if (root != null) {
      visited(depth) = visited.getOrElse(depth, List()) ++ List(root.value)
      loop(root.left, depth + 1)
      loop(root.right, depth + 1)
    }
  }
  loop(root)

  visited.values.toList
}

val input = TreeNode(1, left = TreeNode(2, null), right = TreeNode(3, null))

bfs(input)
