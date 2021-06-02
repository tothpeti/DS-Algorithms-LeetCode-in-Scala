import scala.annotation.tailrec

/*
Problem 344: Reverse String

Write a function that reverses a string. The input string is given as an array of characters s.
 */

def reverseString(s: Array[Char]): Unit = {
  @tailrec
  def helper(st: Array[Char], start: Int, end: Int): Unit = {
    if (start < end) {
      val tmp = st(start)
      st(start) = st(end)
      st(end) = tmp
      helper(st, start + 1, end - 1)
    } else {
      ()
    }
  }
  helper(s, 0, s.length - 1)
}

reverseString(Array('h', 'e', 'l', 'l', 'o'))
