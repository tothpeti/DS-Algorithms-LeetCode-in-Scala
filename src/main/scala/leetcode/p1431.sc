def kidsWithCandies(candies: Array[Int], extraCandies: Int): List[Boolean] = {
  val maximumCandies = candies.max

  val canBeGreatest = (numOfCandies: Int) => {
    if (numOfCandies + extraCandies >= maximumCandies) true else false
  }

  candies.map(kidCandy => canBeGreatest(kidCandy)).toList
}

kidsWithCandies(Array(2, 3, 5, 1, 3), 3)