/*
Problem 373: Find K Pairs with Smallest Sums
 */

def kSmallestPairs(nums1: Array[Int], nums2: Array[Int], k: Int): List[List[Int]] = {
  val tuples = for {
    i <- nums1
    j <- nums2
  } yield (i + j, i, j)

  tuples
    .sortInPlaceWith(_._1 < _._1)
    .take(k)
    .map(elem => List(elem._2, elem._3)).toList
}
kSmallestPairs(Array(1, 2), Array(3), 3)
