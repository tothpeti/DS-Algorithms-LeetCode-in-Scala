/*
Given a string, eg: abc123ab12

Find sum of integers divided by sum of no. of alphabets rounded off to nearest integer

i.e. 1+2+3+1+2/5= 9/5 = 2( 1.8 is rounded off to nearest integer as 2 )
 */
def sumOfIntegersFromString(s: String): Int = {
  val onlyDigits = s.filter(_.isDigit).toCharArray
  val sumOfInts = onlyDigits.foldLeft(0.0)((acc, curr) => acc + curr.asDigit)
  val divided = sumOfInts / onlyDigits.length
  math.ceil(divided).toInt

}

val s = "abc123ab12"

