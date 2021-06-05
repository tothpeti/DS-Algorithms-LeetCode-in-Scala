/*
Problem 82: Remove Duplicates from Sorted List II
 */

case class ListNode(value: Int = 0, var next: ListNode = null)

def deleteDuplicates(head: ListNode): ListNode = {
  if (head == null) return null
  else if (head.next == null) return head

  val dummy = ListNode()
  dummy.next = head

  var curr = dummy.next
  var pre  = dummy

  while(curr.next != null) {
    if (curr.value == curr.next.value) {
      while (curr.next != null && curr.value == curr.next.value) {
        curr = curr.next
      }
      if (curr.next == null) {
        pre.next = null

      } else {
        curr = curr.next
        pre.next = curr
      }
    } else {
      pre = pre.next
      curr = curr.next
    }
  }
  dummy.next
}

val nodes = ListNode(1, ListNode(2, ListNode(3, ListNode(3, ListNode(4, ListNode(4, ListNode(5)))))))


deleteDuplicates(nodes)
