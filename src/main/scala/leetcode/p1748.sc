/*
Problem 1748: Sum of Unique Elements
 */

def sumOfUnique(nums: Array[Int]): Int = {
  nums.groupMapReduce(identity)(_ => 1)(_ + _).filter(e => e._2 == 1).keys.sum
}
