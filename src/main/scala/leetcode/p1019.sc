/*
Problem 1019: Next Greater Node in Linked List
 */
import scala.collection.mutable

case class ListNode(x: Int = 0, var next: ListNode = null)

def nextLargerNodes(head: ListNode): Array[Int] = {
  if (head == null) return Array()

  var dummy = ListNode(0)
  dummy.next = head

  if (head == null) return Array()

  val values = mutable.ArrayBuffer[Int]()

  dummy = dummy.next
  while (dummy != null) {
    values += dummy.x
    dummy = dummy.next
  }

  val result = mutable.ArrayBuffer[Int]()

  for (i <- values.indices) {
    val current = values(i)

    var found = false
    var j = i + 1
    while (j < values.length && !found) {
      if (current < values(j)) {
        result += values(j)
        found = true
      }
      j += 1
    }

    if (!found) {
      result += 0
    }
  }
  result.toArray
}

val nodes = ListNode(2, ListNode(7, ListNode(4, ListNode(3, ListNode(5)))))
nextLargerNodes(nodes)
