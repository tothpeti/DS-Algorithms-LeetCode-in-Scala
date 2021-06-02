
def fizzBuzz(n: Int): List[String] = {
  (1 to n).foldLeft(List[String]()){ (acc, curr) =>
    curr match {
      case elem if elem % 3 == 0 && elem % 5 == 0 => acc :+ "FizzBuzz"
      case elem if elem % 3 == 0 => acc :+ "Fizz"
      case elem if elem % 5 == 0 => acc :+ "Buzz"
      case _ => acc :+ curr.toString
    }
  }
}

fizzBuzz(3)
