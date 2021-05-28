sealed trait MyLinkedList[+A] {
  def head: A
  def tail: MyLinkedList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyLinkedList[B]
  def printElements: String
  override def toString = "[" + printElements + "]"

  def map[B](f: A => B): MyLinkedList[B]
}
case class MyCons[+A](head: A, tail: MyLinkedList[A]) extends MyLinkedList[A] {
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyLinkedList[B] = MyCons(element, this)
  def printElements =
    if (tail.isEmpty) "" + head
    else head + " " + tail.printElements

  def map[B](f: A => B): MyLinkedList[B] = MyCons(f(head), tail.map(f))
}
case object Empty extends MyLinkedList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyLinkedList[B] = MyCons[B](element, Empty)
  def printElements = ""

  def map[B](f: Nothing => B): MyLinkedList[B] = this
}

val listOfInts = MyCons(1, MyCons(2, MyCons(3, Empty)))



