/*
Problem 229: Majority Element II

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 */

def majorityElement(nums: Array[Int]): List[Int] = {
  val boundary = nums.length / 3
  val results =
    nums.groupBy(e => e)
      .map(elem => (elem._1, elem._2.length))
      .filter(elem => elem._2 > boundary)
      .keys
      .toList

  results
}

val arr = Array(1, 2)

majorityElement(arr)
