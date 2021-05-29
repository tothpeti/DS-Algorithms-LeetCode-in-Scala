def quicksort(values: List[Int]): List[Int] = {
  values match {
    case Nil => List()
    case pivot :: tail => {
      val (less, greater) = tail.partition(_ < pivot)
      (quicksort(less) :+ pivot) ++ quicksort(greater)
    }
  }
}

quicksort(List(2, 4, 3, 1, 5))
