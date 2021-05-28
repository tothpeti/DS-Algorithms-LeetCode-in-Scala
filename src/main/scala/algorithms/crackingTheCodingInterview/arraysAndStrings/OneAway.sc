/*
Check if two strings are one edit away from each other.
 */

def oneAway(first: String, second: String): Boolean = {
  if (first.isEmpty || second.isEmpty) false
  else {
    val numOfDifferences = first.compareTo(second)

    if (numOfDifferences == 1 || numOfDifferences == 0) true
    else false
  }
}

oneAway("alma", "al")
