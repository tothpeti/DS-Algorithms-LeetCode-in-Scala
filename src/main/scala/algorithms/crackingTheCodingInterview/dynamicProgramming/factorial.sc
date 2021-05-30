def factorial(n: Int): Long = {
  def rec(counter: Int, a: Long, result: Long): Long = {
    if (counter == 0 || counter == 1) rec(counter + 1, counter, 1)
    else if (counter <= n) 1 * rec(counter + 1,  result, result * counter)
    else result
  }

  rec(0, 0, 0)
}

factorial(6)
