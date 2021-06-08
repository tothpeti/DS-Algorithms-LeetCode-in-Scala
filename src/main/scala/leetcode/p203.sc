/*
Problem 203: Remove Linked List Elements
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def removeElements(head: ListNode, value: Int): ListNode = {
  if (head == null) return head

  val dummy = ListNode()
  dummy.next = head

  var walker = dummy
  while (walker.next != null) {
    if (walker.next.x == value) walker.next = walker.next.next
    else walker = walker.next
  }
  dummy.next
}
