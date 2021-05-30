/*
Problem 70 - Climbing Stairs

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
def climbStairs(n: Int): Int = {
  val dp = new Array[Int](n + 1)

  dp(0) = 1
  dp(1) = 1

  for (i <- 2 to n) {
    dp(i) = dp(i - 1) + dp(i - 2)
  }

  dp(n)
}
