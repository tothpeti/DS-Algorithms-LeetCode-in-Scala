/*
Given two strings, decide if one string is a permutation of the other.
 */

def checkPermutation(first: String, second: String): Boolean = {
  if (first.nonEmpty && second.nonEmpty) {
    val firstSorted = first.toCharArray.sorted.mkString("")
    val secondSorted = second.toCharArray.sorted.mkString("")

    firstSorted.equals(secondSorted)
  } else {
    false
  }
}

// checkPermutation("alma", "alam")

def checkPermutation2(first: String, second: String): Boolean = {
  if (first.isEmpty && second.isEmpty) false

  val letters = new Array[Int](128)

  for (ch <- first) {
    letters(ch) += 1
  }

  for (ch <- second) {
    letters(ch) -= 1
    if (letters(ch) < 0) {
      return false
    }
  }
  true
}
checkPermutation2("alma", "alam")
