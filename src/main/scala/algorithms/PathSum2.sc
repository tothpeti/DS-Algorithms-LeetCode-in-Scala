case class Node(value: Int = 0, left: Node = null, right: Node = null)

def pathSum(root: Node, targetSum: Int): List[List[Int]] = {
  if (root == null) return Nil
  if (root.left == null && root.right == null && targetSum - root.value == 0)
    List(List(root.value))
  else {
      (
        pathSum(root.left, targetSum - root.value) ++
          pathSum(root.right, targetSum - root.value)
      ).map(root.value +: _)
  }
}

val nodes =
  Node(1,
    Node(2, Node(3, Node(4), Node(5))),
    Node(5, Node(4))
  )

pathSum(nodes, 10)
