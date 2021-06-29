import scala.collection.mutable

case class Node(value: Int = 0, left: Node = null, right: Node = null)

def kthSmallest(root: Node, k: Int): Int = {
  if (root == null) return 0

  implicit val ascending: Ordering[Int] = Ordering.fromLessThan((a, b) => a < b)
  val pq = mutable.PriorityQueue[Int]().reverse
  val queue = mutable.Queue[Node](root)

  while (queue.nonEmpty) {
    val queueLength = queue.length

    for (_ <- 0 until queueLength) {
      val node = queue.dequeue()

      pq.enqueue(node.value)

      if (node.left != null) queue.enqueue(node.left)
      if (node.right != null) queue.enqueue(node.right)
    }
  }
  if (pq.nonEmpty) {
    val result = pq.dequeueAll.toArray
    result(k - 1)
  } else 0
}

val nodes =
  Node(3, Node(1, null, Node(2)), Node(4))

kthSmallest(nodes, 1)