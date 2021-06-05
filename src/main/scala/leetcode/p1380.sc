/*
Problem 1380: Lucky Numbers in a Matrix
 */
import scala.collection.mutable

def luckyNumbers(matrix: Array[Array[Int]]): List[Int] = {
  val minimums = matrix.map(subArr => subArr.min)
  val maximums = mutable.ArrayBuffer[Int]()

  for (i <- matrix(0).indices) {
    var maximum = Integer.MIN_VALUE
    for (subArr <- matrix) {
      maximum = math.max(subArr(i), maximum)
    }
    maximums += maximum
  }

  (minimums intersect maximums).toList
}

val matrix =
  Array(
    Array(3, 7, 8),
    Array(9, 11, 13),
    Array(15, 16, 17),
  )

luckyNumbers(matrix)
