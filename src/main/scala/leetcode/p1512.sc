import scala.collection.mutable

def numIdenticalPairs(nums: Array[Int]): Int = {
  var goodPairs = mutable.ArrayBuffer[(Int, Int)]()
  for (i <- nums.indices) {
    for (j <- i until nums.length) {
      if (nums(i) == nums(j) && i < j)
        goodPairs = goodPairs :+ (i, j)
    }
  }

  goodPairs.length
}

numIdenticalPairs(Array(1, 2, 3))