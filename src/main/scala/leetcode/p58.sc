/*
Problem 58: Length of Last Word

Given a string s consists of some words separated by spaces,
return the length of the last word in the string.
If the last word does not exist, return 0.

A word is a maximal substring consisting of non-space characters only.
 */

def lengthOfLastWord(s: String): Int = {
  s match {
    case _ if s.trim == "" => 0
    case _             => s.split(" ").last.length
  }
}

lengthOfLastWord("        ")
