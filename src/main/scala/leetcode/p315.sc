def countSmaller(nums: Array[Int]): Array[Int] = {

  def helper(list: List[Int], results: List[(Int, Int)]): List[Int] = {
    list match {
      case head :: tail =>
        val numberOfLess = tail.count(_ < head)
        helper(tail, results :+ (head, numberOfLess))
      case _ => results.map(_._2)
    }
  }
  val result = helper(nums.toList, List.empty[(Int, Int)])
  result.toArray
}

countSmaller(Array(-1))