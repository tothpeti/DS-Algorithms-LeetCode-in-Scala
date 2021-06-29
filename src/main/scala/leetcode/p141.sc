import scala.collection.mutable

case class ListNode(x: Int = 0, var next: ListNode = null)

def hasCycle(head: ListNode): Boolean = {
  if (head == null) return false

  var walker = head
  var runner = head.next

  while (runner != null && runner.next != null) {
    if (walker == runner) return true

    runner = runner.next.next
    walker = walker.next
  }
  false
}
