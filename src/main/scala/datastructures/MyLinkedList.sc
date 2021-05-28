sealed trait MyLinkedList[+A] {
  def head: A
  def tail: MyLinkedList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyLinkedList[B]
  def printElements: String
  override def toString = "[" + printElements + "]"
}
case class MyCons[+A](h: A, t: MyLinkedList[A]) extends MyLinkedList[A] {
  def head: A = h
  def tail: MyLinkedList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyLinkedList[B] = MyCons(element, this)
  def printElements =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}
case object Empty extends MyLinkedList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyLinkedList[B] = MyCons[B](element, Empty)
  def printElements = ""
}

val listOfInts = MyCons(1, MyCons(2, MyCons(3, Empty)))



