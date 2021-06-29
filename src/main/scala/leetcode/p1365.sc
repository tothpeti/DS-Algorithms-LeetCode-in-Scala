def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
  nums.map(elem => nums.count(_ < elem))
}