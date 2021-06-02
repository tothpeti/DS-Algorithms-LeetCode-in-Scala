/*
Problem 217: Contains Duplicate

Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.
 */

def containsDuplicate(nums: Array[Int]): Boolean = {
  val frequencyList = nums.groupMapReduce(e => e)(_ => 1)(_ + _).filter(_._2 >= 2).toList

  if (frequencyList.nonEmpty) true
  else false
}

containsDuplicate(Array(1,1,1,3,3,4,3,2,4,2))
