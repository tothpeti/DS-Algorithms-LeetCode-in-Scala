case class Node(value: String = "", var next: Node = null)

def detectLoop(head: Node): Node = {
  if (head == null) return null

  val dummy = Node("")
  dummy.next = head

  var walker: Node = dummy.next
  var runner: Node = walker.next

  while (walker != null && runner != null) {
    while (runner != null) {
      if (walker.value == runner.value) {
        val result = walker
        result.next = null
        return result
      }
      runner = runner.next
    }
    walker = walker.next
    runner = walker.next
  }

  Node()
}

val nodes = Node("A", Node("B", Node("C", Node("D", Node("E", Node("C"))))))
detectLoop(nodes)
