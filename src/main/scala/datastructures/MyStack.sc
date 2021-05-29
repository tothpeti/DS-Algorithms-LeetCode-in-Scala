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
      elements = elements.init
      popped
    }

  def length(): Int = elements.length
}

object MyStack {
  def apply[A](values: A*) = new MyStack[A](values:_*)
}


val s = MyStack(1, 2, 3, 4, 5)
s.length()
s.top()
s.pop()
s.top()
