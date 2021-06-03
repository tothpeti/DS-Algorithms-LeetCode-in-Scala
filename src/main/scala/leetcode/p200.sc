import scala.collection.mutable

/*
Problem 200: Number of Islands
 */

object Solution {
  def numIslands(grid: Array[Array[Char]]): Int = {
    val numberOfRows = grid.length
    val numberOfCols = grid(0).length

    val isValid = (row: Int, col: Int, rows: Int, cols: Int) =>
      if (row >= 0 && row < rows && col >= 0 && col < cols) true else false

    // (x, y)
    val queue = mutable.Queue[(Int, Int)]()
    val visited = Array.ofDim[Boolean](numberOfRows, numberOfCols)
    val directions = Array((1, 0), (-1, 0), (0, 1), (0, -1))
    var numberOfIslands = 0

    for (i <- 0 until numberOfRows) {
      for (j <- 0 until numberOfCols) {
        if (!visited(i)(j) && grid(i)(j) == '1') {
          numberOfIslands += 1
          visited(i)(j) = true

          queue.enqueue((i, j))

          while (queue.nonEmpty) {
            val queueLength = queue.length

            for (_ <- 0 until queueLength) {
              val (x, y) = queue.dequeue()

              for (dir <- directions) {
                val newX = x + dir._1
                val newY = y + dir._2

                if (isValid(newX, newY, numberOfRows, numberOfCols) &&
                    !visited(newX)(newY) && grid(newX)(newY) == '1') {
                  queue.enqueue((newX, newY))
                  visited(newX)(newY) = true
                }
              }
            }
          }
        }
      }
    }
    numberOfIslands
  }
}
val grid = Array(
  Array('1', '1', '0', '0', '0'),
  Array('1', '1', '0', '0', '0'),
  Array('0', '0', '1', '0', '0'),
  Array('0', '0', '0', '1', '1')
)

Solution.numIslands(grid)
