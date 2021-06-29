import scala.annotation.tailrec

case class Node(value: Int = 0, left: Node = null, right: Node = null)

def searchBST(root: Node, searched: Int): Node = {
  @tailrec
  def search(node: Node): Node = {
    if (node == null || searched == node.value) return node

    if (node.value < searched) search(node.right)
    else search(node.left)
  }

  search(root)
}