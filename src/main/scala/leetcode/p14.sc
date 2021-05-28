def longestCommonPrefix(words: Array[String]): String = {

  def checkIfCharacterMatch(ch: Char, idx: Int, words: Array[String]): Boolean = {
    words.forall(word => word.charAt(idx) == ch)
  }

  def longestCommon(words: Array[String]): String = {
    if (words.length == 0) {
      ""
    } else if (words.length == 1) {
      words.head
    } else {
      val minLengthWord = words.minBy(_.length)

      if (minLengthWord == "")
        minLengthWord
      else {
        val maxIdxPair =
          minLengthWord.zipWithIndex
            .takeWhile{ pair =>
              checkIfCharacterMatch(pair._1, pair._2, words)
            }

        if (maxIdxPair.isEmpty) ""
        else {
          val maxIdx = maxIdxPair.last._2
          minLengthWord.substring(0, maxIdx + 1) // inclusive
        }
      }
    }
  }

  longestCommon(words)
}
