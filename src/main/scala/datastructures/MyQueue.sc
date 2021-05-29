class MyQueue[A](values: A*) {
  private var elements: List[A] =
    if (values.isEmpty) List.empty[A] else values.toList

  def enqueue(value: A): Unit = elements = elements :+ value

  def dequeue(): Unit =
    elements match {
      case x :: Nil  => elements = List.empty[A]
      case x :: tail => elements = tail
      case Nil       => throw new NoSuchElementException
    }

  def pollFirst(): A =
    elements.headOption match {
      case Some(value) => value
      case None        => throw new NoSuchElementException
    }

  def pollLast(): A =
    elements.lastOption match {
      case Some(value) => value
      case None        => throw new NoSuchElementException
    }

  def length(): Int = elements.length
}

object MyQueue {
  def apply[A](values: A*) = new MyQueue(values:_*)
}

val q = MyQueue(1, 2, 3, 4, 5)
q.pollFirst()
q.pollLast()
q.length()
q.dequeue()
q.enqueue(6)
q.dequeue()
q.length()
q.pollFirst()
