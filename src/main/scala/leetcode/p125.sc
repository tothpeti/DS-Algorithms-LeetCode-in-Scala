import scala.annotation.tailrec

/*
Problem 125: Valid Palindrome

Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

def isPalindrome(s: String): Boolean = {
  /*
  val word = s.replaceAll("""[\p{Punct}]""", "")
    .split(" ")
    .map(_.toLowerCase)
    .mkString("")
  */
  val word = s.filter(_.isLetterOrDigit).toLowerCase

  @tailrec
  def rec(s: String): Boolean = {
    s.isEmpty || ((s.last == s.head) && rec(s.init.tail))
  }
  rec(word)
}
isPalindrome("abba")
