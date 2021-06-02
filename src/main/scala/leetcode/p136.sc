import scala.collection.immutable.HashSet

/*
Problem 136: Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 */

def singleNumber(nums: Array[Int]): Int = {
  nums.groupMapReduce(e => e)(_ => 1)(_ + _).minBy(_._2)._1
}

def singleNumber2(nums: Array[Int]): Int = {
  nums.foldLeft(HashSet.empty[Int]){ (hashSet, curr) =>
    if (hashSet.contains(curr)) hashSet - curr
    else hashSet + curr
  }.head
}

singleNumber(Array(4, 1, 2, 1, 2))
