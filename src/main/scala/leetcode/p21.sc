/*
Problem 21: Merge Two Sorted Lists

Merge two sorted linked lists and return it as a sorted list.
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
  if (l1 == null) l2
  else if (l2 == null) l1
  else if (l1.x < l2.x) {
    l1.next = mergeTwoLists(l1.next, l2)
    l1
  } else {
    l2.next = mergeTwoLists(l1, l2.next)
    l2
  }
}
