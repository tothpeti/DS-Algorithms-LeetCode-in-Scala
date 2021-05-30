case class Node(value: Int = 0, var next: Node = null)

def reverse(head: Node): Node = {
  if (head == null) return null

  val dummy = Node()
  dummy.next = head

  var current = dummy.next
  var next: Node = null
  var reverse: Node = null

  while (current != null) {
    next = current.next
    current.next = reverse
    reverse = current
    current = next
  }
  reverse
}

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))
reverse(nodes)
