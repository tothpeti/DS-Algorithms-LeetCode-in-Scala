sealed trait BinaryTree[+A]
case class Node[A](value: A, left: BinaryTree[A], right: BinaryTree[A]) extends BinaryTree[A]
case object Empty extends BinaryTree[Nothing]

def preorder[A](root: BinaryTree[A]): List[A] = {
  def preorderRec(current: BinaryTree[A]): List[A] = {
    current match {
      case Empty                    => List()
      case Node(value, left, right) => value +: (preorderRec(left) ++ preorderRec(right))
    }
  }

  preorderRec(root)
}

def inorder[A](root: BinaryTree[A]): List[A] = {
  def inorderRec(current: BinaryTree[A]): List[A] = {
    current match {
      case Empty                    => List()
      case Node(value, left, right) =>
        (inorderRec(left) :+ value) ++ inorderRec(right)
    }
  }
  inorderRec(root)
}

def postorder[A](root: BinaryTree[A]): List[A] = {
  def postorderRec(current: BinaryTree[A]): List[A] = {
    current match {
      case Empty => List()
      case Node(value, left, right) =>
        postorder(left) ++ postorder(right) :+ value
    }
  }
  postorderRec(root)
}

val nodes =
  Node(1,
    Node(2,
      Empty,
      Node(3,
        Empty,
        Empty)),
    Empty)

preorder(nodes)
postorder(nodes)
inorder(nodes)
