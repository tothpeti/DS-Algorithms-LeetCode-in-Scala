/*
Problem 24: Swap Nodes in Pairs
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def swapPairs(head: ListNode): ListNode = {
  if (head == null || head.next == null) return head

  var tmp = head.next
  head.next = swapPairs(head.next.next)
  tmp.next = head

  tmp
}
