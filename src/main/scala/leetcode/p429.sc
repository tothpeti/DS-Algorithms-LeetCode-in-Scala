import scala.collection.mutable

case class Node(value: Int, children: List[Node] = List())

def levelOrder(root: Node): List[List[Node]] = {
  if (root == null) return List()

  var levels = mutable.ArrayBuffer[List[Node]]()
  val queue = mutable.Queue[Node](root)

  while (queue.nonEmpty) {
    val queueLength = queue.length
    var levelNodes = mutable.ArrayBuffer[Node]()

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      levelNodes = levelNodes :+ popped
      for (child <- popped.children) {
        if (child != null) queue.enqueue(child)
      }
    }
    levels = levels :+ levelNodes.toList
  }
  levels.toList
}

val nodes =
  Node(1, List(
    Node(3, List(Node(5), Node(6))),
    Node(2),
    Node(4)
  ))

levelOrder(nodes)
