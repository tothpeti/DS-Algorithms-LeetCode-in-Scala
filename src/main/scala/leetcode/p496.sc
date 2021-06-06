/*
Problem 496: Next Greater Element I
 */
import scala.collection.mutable

def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
  if (nums1.isEmpty || nums2.isEmpty) return Array()

  val map = mutable.HashMap[Int, Int]()
  val stack = mutable.Stack[Int]()

  for (num <- nums2) {
    while (stack.nonEmpty && stack.top < num)
      map.update(stack.pop, num)

    stack.push(num)
  }

  for (i <- nums1.indices) {
    nums1(i) = map.getOrElse(nums1(i), -1)
  }

  nums1
}

nextGreaterElement(Array(4, 1, 2), Array(1, 3, 4, 2))
