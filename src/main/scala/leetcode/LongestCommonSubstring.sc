def longestCommonSubstring(a: String, b: String): Int = {
  if (a.length == 0 || b.length == 0) return 0

  val numOfRows = a.length
  val numOfCols = b.length

  val grid = Array.ofDim[Int](numOfRows, numOfCols)
  grid(0)(0) = if (a(0) == b(0)) 1 else 0

  var j = 1
  for (i <- 1 until numOfRows) {
    if (a(i) == b(i))
      grid(i)(j) = grid(i - 1)(j - 1) + 1
    else
      grid(i)(j) = 0

    j += 1
  }
  grid(numOfRows - 1)(numOfCols - 1)
}

longestCommonSubstring("fish", "fod")