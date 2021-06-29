case class Node(value: Int = 0, var next: Node = null)

def removeNthNode(head: Node, n: Int): Node = {
  val dummy = Node()
  dummy.next = head

  var counter = dummy.next
  var length = 0
  while (counter != null) {
    length += 1
    counter = counter.next
  }

  val k = length - n
  var walker = dummy
  var idx = 0
  while (idx < k) {
    idx += 1
    walker = walker.next
  }

  walker.next = walker.next.next

  dummy.next
}