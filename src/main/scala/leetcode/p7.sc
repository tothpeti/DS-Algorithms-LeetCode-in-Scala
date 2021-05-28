/*
Problem: Reverse Integer

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x
causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0

Constraints:
-231 <= x <= 231 - 1
 */

def reverse(x: Int): Int = {
  val isNegative = if (x < 0) -1 else 1
  val absInput = math.abs(x)

  if (absInput < Integer.MAX_VALUE && absInput > Integer.MIN_VALUE) {
    val reversedString = absInput.toString.reverse

    val result =
      if (reversedString.toDouble.isValidInt) {
        if (isNegative > 0 && reversedString.toInt <= Integer.MAX_VALUE)
          reversedString.toInt
        else
          reversedString.toInt * isNegative
      }
      else {
        0
      }
    result
  } else {
    0
  }

}

println(reverse(-2147483648))
