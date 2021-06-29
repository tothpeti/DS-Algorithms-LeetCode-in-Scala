def maximumWealth(accounts: Array[Array[Int]]): Int = {
  val accountSums =
    for {
      account <- accounts
    } yield account.sum

  accountSums.max
}

maximumWealth(
  Array(Array(1, 5), Array(7, 3), Array(3, 5)))