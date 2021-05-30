case class Node(value: Int = 0, var next: Node = null)

def removeDups(head: Node): Node = {
  // dummy node to point to the head of the list
  val dummy = Node(0)
  dummy.next = head

  var walker = dummy

  while (walker.next != null && walker.next.next != null) {
    if (walker.next.value == walker.next.next.value) {
      walker.next = walker.next.next
    }
    walker = walker.next
  }
  dummy.next
}

/* Or this solution can be a good solution, too

def removeDups(head: Node): Node = {
  val dummy = Node()
  dummy.next = head

  var walker = dummy.next
  while (walker != null && walker.next != null) {
    if (walker.value == walker.next.value) {
      walker.next = walker.next.next
    }
    walker = walker.next
  }

  dummy.next
}
 */

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))
removeDups(nodes)
