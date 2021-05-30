def iterativeFibonacci(n: Int): Int = {
  val memo = new Array[Int](n + 1)
  memo(0) = 0
  memo(1) = 1

  var i = 2
  while (i <= n) {
    memo(i) = memo(i - 1) + memo(i - 2)
    i += 1
  }

  memo(n)
}

iterativeFibonacci(10)


def recursiveFibonacci(n: Int): Int = {
  def rec(counter: Int, a: Int, b: Int): Int = {
    if (counter == 0) rec(counter + 1, 0, 0)
    else if (counter == 1) rec(counter + 1, 0, 1)
    else if (counter <= n) rec(counter + 1, b, a + b)
    else b
  }
  rec(0, 0, 0)
}

recursiveFibonacci(10)
