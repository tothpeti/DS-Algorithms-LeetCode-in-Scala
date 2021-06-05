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
      // stepping till the next node's value is not equal to previous node's value
      while (curr.next != null && curr.value == curr.next.value) {
        curr = curr.next
      }

      // Check if the next node is empty or not
      if (curr.next == null) {
        pre.next = null
      } else {
        // need to step one step forward because we early stopped in the while loop
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
