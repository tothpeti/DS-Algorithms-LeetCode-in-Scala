case class Node(value: String = "", var next: Node = null)

def isPalindrome(head: Node): Boolean = {
  val dummy = Node("")
  dummy.next = head

  // Count the length of the linked list
  var count = 0
  var counter = dummy.next
  while(counter.next != null) {
    count += 1
    counter = counter.next
  }

  // Get the middle index
  val start = 0
  val mid = start + (count - start) / 2

  // Reverse linked list from start to mid
  var tmp: Node = null
  var current = dummy.next
  var next = current.next
  var reversed: Node = null

  var i = count - mid
  while(next != null && i != 0) {
    if (reversed == null) {
      reversed = current
      reversed.next = null
    } else {
      tmp = reversed
      reversed = current
      reversed.next = tmp
    }

    current = next
    next = next.next
    i -= 1
  }

  // Check if part start to mid, and mid to end is equal
  while (current.next != null) {
    if (current.value == reversed.value) {
      current = current.next
      reversed = reversed.next
    } else {
      return false
    }
  }
  true
}

val nodes = Node("a", Node("b", Node("b", Node("a"))))
val nodes2 = Node("a", Node("b", Node("b")))
isPalindrome(nodes2)
