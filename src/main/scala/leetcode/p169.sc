/*
Problem 169: Majority Element

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.
 */

def majorityElement(nums: Array[Int]): Int = {
  val average = nums.length / 2
  println(average)
  val result = nums.groupBy(e => e)
    .map(elem => (elem._1, elem._2.length))
    .find(_._2 > average)

  result match {
    case Some(value) => value._1
    case None        => 0
  }
}

val array = Array(1, 1, 1, 1, 1, 1, 4, 5, 6, 4, 1, 3)
majorityElement(array)
