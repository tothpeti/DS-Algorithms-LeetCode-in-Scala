def fibBottomUpBackward(n: Int): Int = {
  if (n == 0) return 0
  if (n <= 2) return 1

  val dp = new Array[Int](n + 2)
  dp(0) = 0
  dp(1) = 1

  for (i <- 1 until n) {
    dp(i + 1) += dp(i) // dp(i) is already solved we can use it to solve other ones
    dp(i + 2) += dp(i)
  }

  dp(n)
}

fibBottomUpBackward(6)
