/*
Problem 215: Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
def findKthLargest(nums: Array[Int], k: Int): Int = {
  nums.sortWith((a, b) => a > b).take(k).last
}

findKthLargest(Array(3,2,3,1,2,4,5,5,6), 4)
