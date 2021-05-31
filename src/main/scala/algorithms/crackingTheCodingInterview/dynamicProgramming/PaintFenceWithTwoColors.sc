/*
Problem: Paint Fence with Two Colors

There is a fence with 'n' posts, each post can be painted with either green or blue color.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total umber of ways you can paint the fence.
 */

def numberOfWays(n: Int): Int = {
  val dp = Array.fill(n + 1, n + 1){2}

  // Green: 1, Blue: 2
  dp(1)(0) = 1
  dp(1)(1) = 1
  dp(2)(0) = 2
  dp(2)(1) = 2

  for (i <- 3 to n) {
    for (j <- 0 to 1) {
      dp(i)(j) = dp(i - 1)(1 - j) + dp(i - 2)(1 - j)
    }
  }

  dp(n)(0) + dp(n)(1)
}

numberOfWays(4)
