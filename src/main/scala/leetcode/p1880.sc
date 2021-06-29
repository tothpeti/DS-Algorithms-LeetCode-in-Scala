def isSumEqual(firstWord: String, secondWord: String, targetWord: String): Boolean = {
  val lookup = ('a' to 'z').toArray
  val first = firstWord.map(lookup.indexOf(_)).mkString("").toInt
  val second = secondWord.map(lookup.indexOf(_)).mkString("").toInt
  var target = targetWord.map(lookup.indexOf(_)).mkString("").toInt

  (first + second) == target
}