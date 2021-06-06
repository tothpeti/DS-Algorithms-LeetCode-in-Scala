import scala.collection.mutable
import scala.annotation.tailrec

/*
Problem: Valid Parenthesis
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
  - Open brackets must be closed by the same type of brackets.
  - Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Example 4:
Input: s = "([)]"
Output: false

Example 5:
Input: s = "{[]}"
Output: true
 */

// functional
def isValid(s: String): Boolean = {

  def popAndGoNext(stack: mutable.Stack[Char], index: Int): Boolean = {
    stack.pop()
    loop(stack, index)
  }

  @tailrec
  def loop(stack: mutable.Stack[Char], index: Int): Boolean = {
    if (index >= s.length) {
      stack.isEmpty
    } else {
      s.charAt(index) match {
        case c @ ('(' | '{' | '[')             => loop(stack.push(c), index + 1)
        case ')' | '}' | ']' if stack.isEmpty  => false
        case c if c == ')' && stack.top == '(' => popAndGoNext(stack, index + 1)
        case c if c == '}' && stack.top == '{' => popAndGoNext(stack, index + 1)
        case c if c == ']' && stack.top == '[' => popAndGoNext(stack, index + 1)
        case _                                 => false
      }
    }
  }
  loop(mutable.Stack[Char](), 0)
}

// imperative
def isValid1(s: String): Boolean = {
  val stack = mutable.Stack[Char]()

  for (c <- s) {
    if (stack.isEmpty) stack.push(c)
    else {
      if (c == '}' && stack.top == '{') stack.pop()
      else if (c == ']' && stack.top == '[') stack.pop()
      else if (c == ')' && stack.top == '(') stack.pop()
      else stack.push(c)
    }
  }
  stack.isEmpty
}


// println(isValid("]"))

val l = List(1, 2, 3, 4, 5, 6)
l.sliding(2, 1).toList.map { list =>
  (list.head * 10 -> list.max)
}.foreach(println)
