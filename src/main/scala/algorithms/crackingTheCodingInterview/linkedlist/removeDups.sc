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

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))
removeDups(nodes)
