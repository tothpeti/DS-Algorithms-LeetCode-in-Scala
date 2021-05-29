case class Node(value: Int = 0, var next: Node = null)

def reverse(head: Node): Node = {
  if (head == null) return null

  val dummy = Node(0)
  dummy.next = head

  var tmp: Node = null
  var current = dummy.next
  var next = current.next
  var reversed: Node = null

  while (next != null) {

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
  }

  reversed
}

var nodes = Node(1, Node(1, Node(2, Node(3, Node(4, Node(4))))))
reverse(nodes)
