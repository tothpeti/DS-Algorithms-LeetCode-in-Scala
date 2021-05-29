
case class Node(value: Int = 0, var next: Node = null)

def deleteMiddleNode(head: Node): Node =  {
  if (head == null) return null

  val dummy = Node(0)
  dummy.next = head

  // Count the length of the linked list
  var counter = dummy.next
  var count = 0
  while(counter.next != null) {
    count += 1
    counter = counter.next
  }

  val start = 0
  var mid = start + (count - start) / 2

  // Walk until reaching the middle Node
  var walker = dummy.next
  while (mid != 0) {
    walker = walker.next
    mid -= 1
  }

  // Remove the middle node
  walker.next = walker.next.next

  dummy.next
}

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))
deleteMiddleNode(nodes)
