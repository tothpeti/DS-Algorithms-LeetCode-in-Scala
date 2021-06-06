/*
Problem 234: Palindrome Linked List
 */
case class ListNode(x: Int = 0, var next: ListNode = null)

def isPalindrome(head: ListNode): Boolean = {
  if (head == null) return false

  var dummy = ListNode()
  dummy.next = head

  // Count the length of the given linked list
  var counter = dummy.next
  var length = 0
  while (counter.next != null) {
    length += 1
    counter = counter.next
  }

  val mid = length / 2

  // step secondHalf until the mid point
  var secondHalf = dummy.next
  var count = 0
  while (secondHalf.next != null && count != mid) {
    count += 1
    secondHalf = secondHalf.next
  }

  // Reverse secondHalf
  var next: ListNode = null
  var curr = secondHalf
  var reversed: ListNode = null

  while (curr != null) {
    next = curr.next
    curr.next = reversed
    reversed  = curr

    curr = next
  }

  // Check if reversed and the dummy are equal
  var walker = dummy.next // step dummy node to the head node
  while (reversed.next != null) {
    if (reversed.x != walker.x)
      return false

    reversed = reversed.next
    walker = walker.next
  }
  true
}
