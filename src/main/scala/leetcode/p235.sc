import scala.annotation.tailrec

case class Node(value: Int = 0, var left: Node = null, var right: Node = null)

@tailrec
def lowestCommonAncestorBST(root: Node, p: Node, q: Node): Node = {
  if (p.value < root.value && q.value < root.value)
    lowestCommonAncestorBST(root.left, p, q)
  else if (p.value > root.value && q.value > root.value)
    lowestCommonAncestorBST(root.right, p, q)
  else root
}
