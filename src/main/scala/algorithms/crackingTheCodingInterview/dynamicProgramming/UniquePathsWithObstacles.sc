/*
Unique Paths with Obstacles
- Robot needs to go from top left corner to bottom right corner
- There are some obstacles in the grid which are needed to be avoided
(Obstacles are indicated by 1s)
- How many unique paths would there be?
 */
def uniquePathsWithObstacles(grid: Array[Array[Int]]): Int = {
  val numberOfRows = grid.length
  val numberOfColumns = grid(0).length
  val dp = Array.ofDim[Int](numberOfRows, numberOfColumns)


  dp(0)(0) = 1

  for (row <- 0 until numberOfRows) {
    for (column <- 0 until numberOfColumns) {
      if (grid(row)(column) == 1) {
        dp(row)(column) = 0
      } else {
        if (row > 0 && column > 0) {
          dp(row)(column) = dp(row - 1)(column) + dp(row)(column - 1)
        } else if (row > 0) {
          dp(row)(column) = dp(row - 1)(column)
        } else if (column > 0) {
          dp(row)(column) = dp(row)(column - 1)
        }
      }
    }
  }

  dp(numberOfRows - 1)(numberOfColumns - 1)
}
val grid = Array(
  Array(0, 0, 0, 0),
  Array(0, 0, 1, 1),
  Array(0, 0, 0, 0)
)

uniquePathsWithObstacles(grid)
