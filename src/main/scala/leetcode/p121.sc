/*
Best Time to Buy and Sell Stock
 */
def maxProfit(prices: Array[Int]): Int = {
  prices.foldLeft((Int.MaxValue, 0)) {
    case ((minimum, maximum), price) =>
      (Math.min(price, minimum), Math.max(maximum, price - minimum))
  }._2
}
