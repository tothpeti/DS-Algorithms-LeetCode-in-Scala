
/*
Climbing only 1 or 2 steps at a time
 */
def climbingStairs1(n: Int): Int = {
  // this version of climbing stairs is a Fibonacci sequence
  var a, b = 1
  var i = 2
  while (i <= n) {
    val c = a + b
    a = b
    b = c

    i += 1
  }
  b
}
// 1 1 2 3 5
// climbingStairs1(5)


/*
Climbing only 1 or 2 or 3 steps at a time
 */
def climbingStairs2(n: Int): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 1
  dp(1) = 1
  dp(2) = 2

  var i = 3
  while (i <= n) {
    dp(i) = dp(i - 1) + dp(i - 2) + dp(i - 3)

    i += 1
  }
  dp(n)
}

// climbingStairs2(5)

/*
Climbing stairs only 1 to 'k' steps at a time
 */
def climbingStairs3(n: Int, k: Int): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 1
  dp(1) = 1

  for (i <- 2 to n) {
    for (j <- 1 to k) {
      if (i - j >= 0) {
        dp(i) += dp(i - j)
      }
    }
  }

  dp(n)
}

// climbingStairs3(5, 2)

/*
Memory optimized version of k steps climbing stairs
 */
def climbingStairs4(n: Int, k: Int): Int = {
  val dp = new Array[Int](k)
  dp(0) = 1

  for (i <- 1 to n) {
    for (j <- 1 until k) {
      if (i - j >= 0) {
        dp(i % k) += dp((i - j) % k)
      }
    }
  }

  dp(n % k)
}
// climbingStairs4(5, 2)

/*
Climbing stairs only 1 to 'k' steps at a time. Now with a twist:
there are red stairs on which we cannot step!
 */
def climbingStairs5(n: Int, k: Int, redStairs: Array[Int]): Int = {
  val dp = new Array[Int](n  + 1)

  dp(0) = 1

  for (i <- 1 to n) {
      for (j <- 1 to k) {
        if (redStairs.contains(i - 1)) {
          dp(i) = 0
        } else {
          if (i - j >= 0) {
            dp(i) += dp(i - j)
          }
        }
      }
  }

  dp(n)
}

//climbingStairs5(7, 3, Array(1, 3, 4))

/*
Paid staircase:
Climbing stairs 1 or 2 steps at a time. Now with a twist:
for each step we add a cost... we need reach the top by minimizing the cost
 */

def climbingStairs6(n: Int, costs: Array[Int]): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 0
  dp(1) = costs(1)

  for (i <- 2 to n) {
    dp(i) = math.min(dp(i - 1), dp(i - 2)) + costs(i)
  }

  dp(n)
}

// climbingStairs6(3, Array(0, 3, 2, 4))

/*
Paid staircase version 2 (with the twist of variable k steps)
 */

def climbingStairs7(n: Int, k: Int, costs: Array[Int]): Int = {
  val dp = new Array[Int](n + 1)
  dp(0) = 0
  dp(1) = costs(1)

  for (i <- 2 to n) {
    var minCost = Integer.MAX_VALUE
    for (j <- 1 to k) {
      if (i - j >= 0) {
        minCost = math.min(minCost, dp(i - j))
      }
    }
    dp(i) = minCost + costs(i)
  }

  dp(n)
}
// climbingStairs7(3, 2, Array(0, 3, 2, 4))


/*
Paid staircase version 3 (need to return the cheapest path to the top
 */

def climbingStairs8(n: Int, costs: Array[Int]): Seq[Int] = {
  val dp = new Array[Int](n + 1)
  val from = new Array[Int](n + 1)

  dp(0) = 0
  dp(1) = costs(1)

  for (i <- 2 to n) {
    dp(i) = math.min(dp(i - 1), dp(i - 2)) + costs(i)
    if (dp(i - 1) < dp(i - 2)) {
      from(i) = i - 1
    } else {
      from(i) = i - 2
    }
  }

  var path = Seq.empty[Int]
  for (i <- n to 0 by -1) {
    path = path :+ from(i)
    if (from(i) == 0) return path
  }

  path
}
climbingStairs8(8, Array(0, 3, 2, 4, 6, 1, 1, 5, 3))
