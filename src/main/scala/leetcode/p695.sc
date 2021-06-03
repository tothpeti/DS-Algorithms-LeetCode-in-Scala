import scala.collection.mutable

/*
Problem 695: Max Area of Island
 */

object Solution {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val numberOfRows = grid.length
    val numberOfCols = grid(0).length

    val isValid = (row: Int, rows: Int, col: Int, cols: Int) =>
      if (row >= 0 && row < rows && col >= 0 && col < cols) true else false

    val queue = mutable.Queue[(Int, Int)]()
    val visited = Array.ofDim[Boolean](numberOfRows, numberOfCols)
    val directions = Array((1, 0), (-1, 0), (0, -1), (0, 1))
    var areas = mutable.ArrayBuffer[Int]()
    var areaCells = 0

    for (i <- 0 until numberOfRows) {
      for (j <- 0 until numberOfCols) {
        if (!visited(i)(j) && grid(i)(j) == 1) {
          areaCells = 1
          visited(i)(j) = true

          queue.enqueue((i, j))

          while (queue.nonEmpty) {
            val queueLength = queue.length

            for(_ <- 0 until queueLength) {
              val (x, y) = queue.dequeue()

              for (d <- directions) {
                val newX = x + d._1
                val newY = y + d._2

                if (isValid(newX, numberOfRows, newY, numberOfCols) &&
                  !visited(newX)(newY) && grid(newX)(newY) == 1) {
                  visited(newX)(newY) = true
                  areaCells += 1
                  queue.enqueue((newX, newY))
                }
              }
            }
          }
          areas = areas :+ areaCells
        }
      }
    }
    if (areas.nonEmpty)
      areas.max
    else 0
  }
}

val grid =
  Array(
    Array(0,0,1,0,0,0,0,1,0,0,0,0,0) ,Array(0,0,0,0,0,0,0,1,1,1,0,0,0),Array(0,1,1,0,1,0,0,0,0,0,0,0,0),
    Array(0,1,0,0,1,1,0,0,1,0,1,0,0),Array(0,1,0,0,1,1,0,0,1,1,1,0,0),Array(0,0,0,0,0,0,0,0,0,0,1,0,0),
    Array(0,0,0,0,0,0,0,1,1,1,0,0,0),Array(0,0,0,0,0,0,0,1,1,0,0,0,0)
  )

val grid2 =
  Array(Array(0, 0, 0, 0, 0, 0, 0))
Solution.maxAreaOfIsland(grid2)
