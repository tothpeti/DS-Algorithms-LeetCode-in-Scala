/*
A robot is located in the top left corner.
It can only move either down or right at any point in time.
How many possible unique paths are in the grid?
(from top-left to bottom-right)
 */
// Transition function: F(i, j) = F(i - 1, j) + F(i, j - 1)
def uniquePaths(numberOfRows: Int, numberOfColumns: Int): Int = {
  val dp = Array.ofDim[Int](numberOfRows, numberOfColumns)

  dp(0)(0) = 1

  for (row <- 0 until numberOfRows) {
    for (column <- 0 until numberOfColumns) {
      if (row > 0 && column > 0) {
        dp(row)(column) = dp(row - 1)(column) + dp(row)(column - 1)
      } else if (row > 0) {
        dp(row)(column) = dp(row - 1)(column)
      } else if (column > 0) {
        dp(row)(column) = dp(row)(column - 1)
      }
    }
  }

  dp(numberOfRows - 1)(numberOfColumns - 1)
}

uniquePaths(3, 4)
