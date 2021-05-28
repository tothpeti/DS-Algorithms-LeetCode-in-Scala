/*
Write a method which replaces all the spaces in a string with '%20'
 */

def urlify(s: String): String = {
  s.split(" ")
    .mkString("%20")
}

urlify("Mr John Smith    ")
