/*
Problem 347: Top K Frequent Elements
 */

def topKFrequent(nums: Array[Int], k: Int): Array[Int] = {
  nums.groupMapReduce(e => e)(_ => 1)(_ + _)
    .toList
    .sortWith((pair1, pair2) => pair1._2 > pair2._2)
    .take(k)
    .map(pair => pair._1)
    .toArray
}

topKFrequent(Array(4, 1, -1, 2, -1, 2, 3), 2)
