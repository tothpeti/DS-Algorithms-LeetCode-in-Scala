/*
Problem 876: Middle of the Linked List
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def middleNode(head: ListNode): ListNode = {
  val dummy = ListNode(0)
  dummy.next = head

  var counter = dummy.next
  var length = 0
  while(counter != null) {
    length += 1
    counter = counter.next
  }

  val mid = length / 2
  var walker = dummy.next

  var i = 0
  while (i != mid) {
    walker = walker.next
    i += 1
  }
  walker
}

val nodes = ListNode(1, ListNode(2, ListNode(3, ListNode(4))))
middleNode(nodes)
