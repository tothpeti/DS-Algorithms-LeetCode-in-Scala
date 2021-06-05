import scala.collection.mutable

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def smallestFromLeaf(root: TreeNode): String = {
  val paths = mutable.ArrayBuffer[Vector[Int]]()
  val letters = ('a' to 'z').zipWithIndex.map {
    case (v, i) => (i, v)
  }.toMap

  def dfs(node: TreeNode, path: Vector[Int]): Unit = {
    if (node == null) return
    if (node.left == null && node.right == null) {
      paths += (path :+ node.value)
    }
    dfs(node.left, path :+ node.value)
    dfs(node.right, path :+ node.value)
  }

  dfs(root, Vector.empty[Int])

  val resultPaths = paths.map(path =>
    path.map(elem => letters(elem)).reverse.mkString("")
  ).sorted

  resultPaths.headOption match {
    case Some(value) => value
    case None        => ""
  }
}

val nodes =
  TreeNode(25,
    TreeNode(1, TreeNode(3), TreeNode(1)),
    TreeNode(3, TreeNode(0), TreeNode(2)))

smallestFromLeaf(nodes)
