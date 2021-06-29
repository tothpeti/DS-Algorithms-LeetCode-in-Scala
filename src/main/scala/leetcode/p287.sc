def findDuplicate(nums: Array[Int]): Int = {
  val distinct = nums.distinct
  (nums diff distinct)(0)
}