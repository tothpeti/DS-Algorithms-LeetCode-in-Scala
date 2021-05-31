def fibBottomUpForward(n: Int): Int = {
  if (n == 0) return 0
  if (n <= 2) return 1

  val dp = new Array[Int](n + 1)

  dp(0) = 0
  dp(1) = 1

  for (i <- 2 to n) {
    dp(i) = dp(i - 1) + dp(i - 2)
  }

  dp(n)
}

fibBottomUpForward(6)
