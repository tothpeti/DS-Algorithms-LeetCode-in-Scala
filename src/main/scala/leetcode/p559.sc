import scala.collection.mutable

/*
Problem 559: Maximum Depth of N-ary Tree

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */

case class Node(value: Int = 0, children: List[Node] = null)

def maximumDepth(root: Node): Int = {
  if (root == null) return 0

  val queue = mutable.Queue(root)
  var maxDepth = 0

  while(queue.nonEmpty) {
    val queueLength = queue.length

    for (i <- 0 until queueLength) {
      val popped = queue.dequeue()

      for (child <- popped.children) {
        queue.enqueue(child)
      }
    }
    maxDepth += 1
  }
  maxDepth
}

val nodes =
  Node(1,
    List(Node(3, List(Node(5), Node(6))),
      Node(2),
      Node(4)))
maximumDepth(nodes)
