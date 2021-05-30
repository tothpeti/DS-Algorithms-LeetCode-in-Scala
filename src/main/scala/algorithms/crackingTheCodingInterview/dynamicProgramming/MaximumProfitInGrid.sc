/*
Maximum Profit In a Grid:

- A robot is located in the top left corner.
- It can only move either down or right at any point in time.
- Each cell contains a coin
- What is the maximum profit the robot can collect?
 */
def maximumProfitInGrid(grid: Array[Array[Int]]): Int = {
  val numberOfRows = grid.length
  val numberOfColumns = grid(0).length
  val dp = Array.ofDim[Int](numberOfRows, numberOfColumns)

  dp(0)(0) = 0

  for (i <- 0 until numberOfRows) {
    for (j <- 0 until numberOfColumns) {
      if (i > 0 && j > 0) {
        dp(i)(j) = math.max(dp(i - 1)(j), dp(i)(j - 1)) + grid(i)(j)
      } else if (i > 0) {
        dp(i)(j) = dp(i - 1)(j) + grid(i)(j)
      } else if (j > 0) {
        dp(i)(j) = dp(i)(j - 1) +  grid(i)(j)
      }
    }
  }
  dp(numberOfRows - 1)(numberOfColumns - 1)
}

val grid = Array(
  Array(0, 2, 2, 1),
  Array(3, 1, 1, 1),
  Array(4, 4, 2, 0)
)

maximumProfitInGrid(grid)
