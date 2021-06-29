def shuffle(nums: Array[Int], n: Int): Array[Int] = {
  val (first, second) =nums.splitAt(n)

  def merge(a: List[Int], b: List[Int]): List[Int] = {
    (a, b) match {
      case (aHead :: aTail, bHead :: bTail) => List(aHead, bHead) ::: merge(aTail, bTail)
      case _  => List()
    }
  }

  merge(first.toList, second.toList).toArray
}

def shuffle2(nums: Array[Int], n: Int): Array[Int] = {
  val (x, y) = nums.splitAt(n)
  (x zip y).flatMap(i => List(i._1, i._2))
}

shuffle(Array(2, 5, 1, 3, 4, 7), 3)