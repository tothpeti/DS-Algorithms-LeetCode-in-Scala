/*
Problem 160: Intersection of Two Linked Lists

Given the heads of two singly linked-lists headA and headB,
return the node at which the two lists intersect.
If the two linked lists have no intersection at all, return null.d
 */

case class ListNode(x: Int = 0, var next: ListNode = null)

def getIntersectionNode(headA: ListNode, headB: ListNode): ListNode = {
  if (headA == null || headB == null) return null
  var a = headA
  var b = headB

  while (a != b) {
    a = if(a == null) headB else a.next
    b = if(b == null) headA else b.next
  }
  a
}


var headA = ListNode(4, ListNode(1, ListNode(8, ListNode(4, ListNode(5)))))
var headB = ListNode(5, ListNode(6, ListNode(1, ListNode(8, ListNode(4, ListNode(5))))))
getIntersectionNode(headA, headB)
