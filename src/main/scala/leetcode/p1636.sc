/*
Problem 1636: Sort Array by Increasing Frequency
 */

def frequencySort(nums: Array[Int]): Array[Int] = {
  val freqMap =
    nums.groupMapReduce(identity)(_ => 1)(_ + _)

  nums.sortBy(t => (freqMap(t), -t))
}
frequencySort(Array(2,3,1,3,2))
