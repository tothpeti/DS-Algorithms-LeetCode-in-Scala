def numJewelsInStones(jewels: String, stones: String): Int = {
  val setOfJewels = jewels.toSet
  stones.filter(setOfJewels.contains).length
}

numJewelsInStones("z", "ZZ")