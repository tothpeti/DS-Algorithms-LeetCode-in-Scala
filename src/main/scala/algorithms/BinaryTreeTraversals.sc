

case class TreeNode(value: Int = 0, left: TreeNode = null, right: TreeNode = null)

def preOrderTraversal(root: TreeNode): List[Int] = {
  def preOrder(root: TreeNode): List[Int] = {
    root match {
      case null => List()
      case _    => root.value :: preOrder(root.left) ::: preOrder(root.right)
    }
  }
  preOrder(root)
}

def inOrderTraversal(root: TreeNode): List[Int] = {
  def inOrder(root: TreeNode): List[Int] = {
    root match {
      case null => List()
      case _    => inOrder(root.left) ::: root.value :: inOrder(root.right)
    }
  }
  inOrder(root)
}

def postOrderTraversal(root: TreeNode): List[Int] = {
  def postOrder(root: TreeNode): List[Int] = {
    root match {
      case null => List()
      case _    => postOrder(root.left) ++ postOrder(root.right) :+ root.value
    }
  }
  postOrder(root)
}

/*
def preOrderTraversalMutable(root: TreeNode): List[Int] = {

  val values = ArrayBuffer.empty[Int]

  def loop(node: TreeNode): Unit = {
    values += node.value
    loop(node.left)
    loop(node.right)
  }

  loop(root)
  values.toList
}

 */
