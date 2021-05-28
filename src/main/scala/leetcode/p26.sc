/*
Problem 26: Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates
in-place such that each element appears only once
and returns the new length.
 */


def removeDuplicates(nums: Array[Int]): Int = {
  if (nums.isEmpty) 0
  else {
    var i = 0

    for (j <- 1 until nums.length) {
      if (nums(j) != nums(i)) {
        i = i + 1
        nums(i) = nums(j)
      }
    }
    i + 1
  }
}

removeDuplicates(Array(1, 1, 2))
