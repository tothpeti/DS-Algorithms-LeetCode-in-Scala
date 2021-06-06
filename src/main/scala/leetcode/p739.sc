/*
Problem 739: Daily Temperatures
 */

import scala.collection.mutable

def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
  if (temperatures.isEmpty) return Array()

  val result = new Array[Int](temperatures.length)
  val stack = mutable.Stack[Int]()

  for (i <- temperatures.indices) {
    while (stack.nonEmpty && temperatures(stack.top) < temperatures(i)) {
      val prevIdx = stack.top + 1
      val currIdx = i + 1
      result(stack.pop) = currIdx - prevIdx
    }
    stack.push(i)
  }

  result
}

val temps = Array(30, 40, 50, 60)
dailyTemperatures(temps)
