import scala.collection.mutable

def nextGreaterElements(nums: Array[Int]): Array[Int] = {
  if (nums.isEmpty) return Array()

  val result = Array.fill(nums.length)(-1)
  val stack = mutable.Stack[Int]()

  for (i <- 0 until nums.length * 2) {
    val num = nums(i % nums.length)
    while (stack.nonEmpty && nums(stack.top) < num) {
      result(stack.pop) = num
    }

    if (i < nums.length)
      stack.push(i)
  }

  result
}
