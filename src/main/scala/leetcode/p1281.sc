def subtractProductAndSum(n: Int): Int = {
  val numberToString = n.toString
  val product = numberToString.foldLeft(1)((acc, curr) => acc * curr.asDigit)
  val sum = numberToString.foldLeft(0)((acc, curr) => acc + curr.asDigit)

  product - sum
}

subtractProductAndSum(234)