import scala.annotation.tailrec

def numberOfSteps(num: Int): Int = {
  var number = num
  var counter: Int = 0

  while (number != 0) {
    if (number % 2 == 0) number /= 2
    else number -= 1

    counter += 1
  }
  counter
}

def numberOfSteps2(num: Int): Int = {
  @tailrec
  def helper(number: Int, counter: Int = 0): Int = {
    number match {
      case elem if elem % 2 == 0 => helper(elem / 2, counter + 1)
      case elem if elem % 2 == 1 => helper(elem - 1, counter + 1)
      case _ => 0
    }
  }
  helper(num)
}
numberOfSteps(14)