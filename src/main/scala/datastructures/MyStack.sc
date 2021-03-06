class MyStack[A](values: A*){
  private var elements: List[A] =
    if (values.isEmpty) List.empty[A] else values.toList

  def top(): A =
    if (elements.isEmpty) throw new NoSuchElementException
    else elements.last

  def push(element: A): Unit = elements = elements :+ element

  def pop(): A =
    if (elements.isEmpty) throw new NoSuchElementException
    else {
      val popped = elements.last
      elements = if (elements.isEmpty) List.empty[A] else elements.init
      popped
    }

  def length(): Int = elements.length

  def isEmpty(): Boolean = elements.isEmpty
}

object MyStack {
  def apply[A](values: A*) = new MyStack[A](values:_*)
}


val s = MyStack(1)
s.length()
s.top()
s.pop()
s.top()
