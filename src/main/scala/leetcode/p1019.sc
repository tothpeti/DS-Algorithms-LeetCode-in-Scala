/*
Problem 1019: Next Greater Node in Linked List
 */
import scala.collection.mutable

case class ListNode(x: Int = 0, var next: ListNode = null)

def nextLargerNodes(head: ListNode): Array[Int] = {
  if (head == null) return Array()

  var dummy = ListNode(0)
  dummy.next = head

  val values = mutable.ArrayBuffer[Int]()

  dummy = dummy.next
  while (dummy != null) {
    values += dummy.x
    dummy = dummy.next
  }

  // Create a value.size-d Array with 0 values
  val result = new Array[Int](values.size)
  val stack = mutable.Stack[Int]()

  for (i <- values.indices) {
    while (stack.nonEmpty && values(stack.top) < values(i))
      result(stack.pop()) = values(i)

    stack.push(i)
  }
  result
}

val nodes = ListNode(2, ListNode(7, ListNode(4, ListNode(3, ListNode(5)))))
nextLargerNodes(nodes)
