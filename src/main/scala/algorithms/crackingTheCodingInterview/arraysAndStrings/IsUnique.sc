/*
Determine if a string has only unique characters.
 */

def isUnique(word: String): Boolean = {
  def rec(word: String, visitedChars: Set[Char]): Boolean = {
    if (word.isEmpty && visitedChars.nonEmpty) true
    else if (word.isEmpty && visitedChars.isEmpty) false
    else {
      word.headOption match {
        case Some(head) if visitedChars.contains(head)  => false
        case Some(head) if !visitedChars.contains(head) => rec(word.tail, visitedChars + head)
        case None                                       => false
      }
    }
  }
  rec(word, Set.empty[Char])
}

isUnique("")
