def factorial(n: Int): Long = {
  def rec(counter: Int, a: Long, result: Long): Long = {
    if (counter == 0 || counter == 1) rec(counter + 1, counter, 1)
    else if (counter <= n) 1 * rec(counter + 1, result, result * counter)
    else result
  }

  rec(0, 0, 0)
}

factorial(6)

def iterativeFactorial(n: Int): Long = {
  val memo = new Array[Long](n + 1)

  memo(0) = 1
  memo(1) = 1
  var i = 2
  while (i <= n) {
    memo(i) = memo(i - 1) * i
    i += 1
  }

  memo(n)
}

iterativeFactorial(6)
