def runningSum(nums: Array[Int]): Array[Int] = {
  nums.scanLeft(0)(_ + _).tail
}