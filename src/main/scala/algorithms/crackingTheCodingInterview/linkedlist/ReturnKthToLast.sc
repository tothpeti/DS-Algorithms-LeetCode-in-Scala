
case class Node(value: Int = 0, var next: Node = null)

def returnKthToLast(head: Node, k: Int): Node = {
  if (head == null) return null

  val dummy = Node(0)
  dummy.next = head

  var counter = dummy.next
  var i = 0
  while (counter.next != null) {
    counter = counter.next
    i += 1
  }

  var stepsToMove = i - k
  var walker = dummy.next

  while(stepsToMove != 0) {
    walker = walker.next
    stepsToMove -= 1
  }

  walker
}

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))

returnKthToLast(nodes, 2)
