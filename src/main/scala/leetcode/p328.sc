/*
Problem 328: Odd Even Linked List
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def oddEvenList(head: ListNode): ListNode = {
  if (head == null) return head

  val dummy = ListNode()
  dummy.next = head

  var odd = dummy.next
  var even = odd.next
  var evenHead = even

  while (even != null && even.next != null) {
    odd.next = odd.next.next
    even.next = even.next.next

    even = even.next
    odd = odd.next
  }
  odd.next = evenHead

  dummy.next
}
