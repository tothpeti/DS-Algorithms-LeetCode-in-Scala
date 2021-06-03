/*
Problem 378: Kth Smallest Element in a Sorted Matrix
 */

def kthSmallest(matrix: Array[Array[Int]], k: Int): Int = {
  val tmp = matrix.flatMap(_.toList).sortInPlaceWith(_ < _)
  tmp(k - 1)
}

kthSmallest(Array(Array(1, 5, 9), Array(10, 11, 13), Array(12, 13, 15)), 8)
