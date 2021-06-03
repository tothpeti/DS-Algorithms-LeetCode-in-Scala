/*
Problem 268: Missing Number
 */

def missingNumber(nums: Array[Int]): Int = {
  val numRange = (0 to nums.length).toList
  val numSet = nums.toSet

  numRange.filterNot(numSet.contains).headOption match {
    case Some(value) => value
    case None        => 0
  }
}

missingNumber(Array(9,6,4,2,3,5,7,0,1))
