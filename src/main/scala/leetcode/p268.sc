def missingNumber(nums: Array[Int]): Int = {
  val range = (0 to nums.length)
  (range diff nums)(0)
}