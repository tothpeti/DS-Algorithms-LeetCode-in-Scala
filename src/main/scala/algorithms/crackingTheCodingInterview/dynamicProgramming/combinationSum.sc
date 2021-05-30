/*
Given the target value N and an array of allowed numbers,
count ways to write N as the sum of those numbers.
 */

def combinationSum(n: Int, nums: Array[Int]): Int = {
  val memo = new Array[Int](n + 1)
  memo(0) = 1

  var i = 1
  while (i <= n) {
    for (num <- nums) {
      if (num - i >= 0) {
        memo(i) += memo(num - i)
      }
    }
    i += 1
  }
  memo.foreach(println)
  memo(n)
}

// combinationSum(4, Array(1, 2, 3))
