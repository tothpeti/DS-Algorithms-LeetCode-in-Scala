/*
Problem 83: Remove Duplicates from Sorted List

Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
Return the linked list sorted as well.
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def deleteDuplicates(head: ListNode): ListNode = {
  if (head == null || head.next == null) {
    head
  } else {
    var dummy = head
    while (dummy.next != null) {
      if (dummy.x == dummy.next.x) dummy.next = dummy.next.next
      else dummy = dummy.next
    }
    head
  }

}

var head = ListNode(1, ListNode(1, ListNode(2, ListNode(1, ListNode(1)))))

println(deleteDuplicates(head))
