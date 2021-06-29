def longestCommonSubsequence(text1: String, text2: String): Int = {
  if (text1.length == 0 || text2.length == 0) return 0

  val numberOfRows = text1.length
  val numberOfCols = text2.length

  val grid = Array.ofDim[Int](numberOfRows, numberOfCols)

  for (i <- 0 until numberOfRows) {
    for (j <- i until numberOfCols) {
      println(s"$i $j")
      if (text1(i) == text2(j)) {
        println(s"${text1(i)} , ${text2(j)}")
        if (i == 0 && j == 0){
          grid(i)(j) += 1
          println("here")
        }
        else if (i == j) {
          grid(i)(j) = grid(i - 1)(j - 1) + 1
          println("hello")
        }
        else if (i > 0) {
          grid(i)(j) = math.max(grid(i - 1)(j), grid(i)(j - 1)) + 1
          println("oh hey")
        }
      }
    }
  }

  // grid.foreach(_.foreach(println))
  1
  // grid(numberOfRows - 1)(numberOfCols - 1)
}

longestCommonSubsequence("abcde", "ace")