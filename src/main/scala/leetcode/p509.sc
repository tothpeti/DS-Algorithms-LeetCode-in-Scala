import scala.annotation.tailrec

/*
Problem 509: Fibonacci Number
 */

def fib(n: Int): Int = {
  @tailrec
  def helper(idx: Int, a: Int, b: Int): Int = {
    if (n == 0) 0
    else if (idx == 1 || idx == 2) helper(idx + 1, 1, 1)
    else if (idx <= n) helper(idx + 1, b, a + b)
    else b
  }

  helper(0, 0, 0)
}

fib(3)
