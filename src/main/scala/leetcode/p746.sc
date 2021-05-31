/*
Problem 746: Min Cost Climbing Stairs
You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
 */

def minCostClimbingStairs(costs: Array[Int]): Int = {
  val n = costs.length
  val dp = new Array[Int](n)

  for (i <- costs.indices) {
    if (i < 2) dp(i) = costs(i)
    else
      dp(i) = math.min(dp(i - 1), dp(i - 2)) + costs(i)
  }

  math.min(dp(n - 1), dp(n - 2))
}

val costs = Array(10,15,20)
minCostClimbingStairs(costs)
