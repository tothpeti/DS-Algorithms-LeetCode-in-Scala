import scala.annotation.tailrec
import scala.collection.immutable.HashMap


/*
Problem: Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Constraints:
  ->   2 <= nums.length <= 104
  ->   -109 <= nums[i] <= 109
  ->   -109 <= target <= 109
  ->   Only one valid answer exists.
 */

// functional
def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  @tailrec
  def loop(compliments: HashMap[Int, Int], index: Int): Array[Int] = {
    if (index == nums.length) Array(0)
    else {
      val diff = target - nums(index)
      compliments.get(diff) match {
        case Some(idx) => Array(idx, index)
        case None      => loop(compliments + (nums(index) -> index), index + 1)
      }
    }
  }
  loop(HashMap[Int, Int](), 0)
}

// imperative - brute force
/*
def twoSum(nums: Array[Int], target: Int): Array[Int] = {
  var pair: (Int, Int) = (0, 0)
  for (
    i <- (0 to nums.length by 1);
    j <- (nums.length - 1 until i by -1)
  ) {
    val tmpSum = nums(i) + nums(j)

    if (tmpSum == target) pair = (i, j)
  }

  Array(pair._1, pair._2)
}

twoSum(Array(2,7,11,15), 9)
twoSum(Array(3, 2, 4), 6)
twoSum(Array(3, 3), 6)


 */
Array(2, 4, 5, 6).zipWithIndex.sliding(2, 1).take(2).foreach(elem => println(s"${elem(0)} + ${elem(1)}"))
