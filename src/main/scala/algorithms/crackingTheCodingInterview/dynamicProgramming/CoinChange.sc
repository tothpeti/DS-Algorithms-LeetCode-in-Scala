/*
Problem: Coin Change

Given an unlimited supply of coins of given denominations,
find the total number of ways to make a change of size n.

For this we can use the following coins: 1, 3, 5, 10
 */

def coinChange(n: Int): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 1

  for (i <- 1 to n) {
    if (i >= 1) {
      dp(i) += dp(i - 1)
    }
    if (i >= 3) {
      dp(i) += dp(i - 3)
    }
    if (i >= 5) {
      dp(i) += dp(i - 5)
    }
    if (i >= 10) {
      dp(i) += dp(i - 10)
    }
  }

  dp(n)
}

// coinChange(4)

def coinChangeWithCoins(n: Int, coins: Array[Int]): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 1

  for (i <- 1 to n) {
    for (coin <- coins) {
      if (i - coin >= 0) {
        dp(i) += dp(i - coin)
      }
    }
  }

  dp(n)
}

coinChangeWithCoins(4, Array(1, 3, 5, 10))

/*

 */
