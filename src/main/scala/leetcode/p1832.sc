def checkIfPangram(sentence: String): Boolean = {
  // which are greater than 0
  val englishLetters = ('a' to 'z').toSet
  val frequenciesOfLetters = sentence.groupMapReduce(e => e)(_ => 1)(_ + _)
  val letters = frequenciesOfLetters.keys

  val filteredWords = letters.filter(englishLetters.contains).toList.length
  val filteredFreqs = frequenciesOfLetters.values.filter(_ > 0).toList.length

  val numberOfEnglishLetter = englishLetters.toList.length
  if (filteredWords == numberOfEnglishLetter && filteredFreqs == numberOfEnglishLetter)
    true
  else
    false
}
val s = "leetcode"
checkIfPangram(s)