import scala.collection.mutable
import scala.annotation.tailrec

def reverse1(s: String): String = {
  def helper(current: String, result: String): String = {
    if (current.isEmpty) {
      result
    } else {
      helper(current.init, result + current.last)
    }
  }
  helper(s, "")
}

def reverse2(s: String): String =
  s.foldRight("")((acc, curr) => curr + acc)

def reverse3(s: String): String = {
  var result = ""
  for (idx <- s.length - 1 to 0 by -1) {
    result += s.charAt(idx)
  }
  result
}

def reverseList[A](l: Seq[A]): Seq[A] = {
  def helper(current: Seq[A], result: Seq[A]): Seq[A] = {
    if (current.isEmpty) {
      result
    } else {
      helper(current.init, result :+ current.last)
    }
  }
  helper(l, Seq.empty[A])
}


def isRepeatingChar(s: String): Boolean = {
  def helper(current: String, visitedChars: Set[Char]): Boolean = {
    if (current.isEmpty) false
    else {
      current.headOption match {
        case Some(head) if !visitedChars.contains(head) =>  {
          helper(current.tail, visitedChars + head)
        }
        case Some(head) if visitedChars.contains(head) => true
        case None => false
      }
    }
  }
  helper(s, Set.empty[Char])
}

def findMaxInStack(stack: mutable.Stack[Int]): Int = {
  def helper(remainingStack: mutable.Stack[Int], maxElem: Int = Integer.MIN_VALUE): Int = {
    if (remainingStack.isEmpty) maxElem
    else {
      helper(remainingStack, math.max(maxElem, remainingStack.pop()))
    }
  }
  helper(stack)
}



def fibonacci(till: Int): Seq[Int] = {
  @tailrec
  def fibonacciRec(counter: Int = 0, first: Int, second: Int, result: Seq[Int]): Seq[Int] = {
    if (counter == till) result
    else if (counter == 0) fibonacciRec(counter + 1, 0, 0, result :+ counter)
    else if (counter == 1) fibonacciRec(counter + 1, 0, 1, result :+ counter)
    else fibonacciRec(counter + 1, second, first + second, result :+ (first + second))
  }
  fibonacciRec(0, 0, 0, Seq.empty[Int])
}


def binarySearch(list: Seq[Int], value: Int): Int = {
  def binaryRec(currentList: Seq[Int], target: Int, start: Int, end: Int): Int = {
    if (start > end) -1
    else {
      val mid = start + (end - start) / 2
      currentList(mid) match {
        case element if element == target => mid
        case element if element > target  => binaryRec(currentList, target, start, mid - 1)
        case _                            => binaryRec(currentList, target, mid + 1, end)
      }
    }
  }

  binaryRec(list, value, 0, list.length - 1)
}


def len(list: Seq[_]): Int = {
  @tailrec
  def rec(current: Seq[_], counter: Int): Int = {
    current match {
      case Nil => 0
      case _ :: tail => rec(tail, counter + 1)
    }
  }
  rec(list, 0)
}

sealed trait Tree[+A]
final case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]
final case object Empty extends Tree[Nothing]

def preOrder[A](tree: Tree[A]): Seq[A] = {
  def rec(currentNode: Tree[A]): Seq[A] = {
    currentNode match {
      case Node(value, left, right) => value +: (rec(left) ++ rec(right))
      case _                        => Seq()
    }
  }
  rec(tree)
}

def inOrder[A](tree: Tree[A]): Seq[A] = {
  def rec(currentNode: Tree[A]): Seq[A] = {
    currentNode match {
      case Node(value, left, right) => (rec(left) :+ value) ++ rec(right)
      case _                        => Seq()
    }
  }
  rec(tree)
}

def postOrder[A](tree: Tree[A]): Seq[A] = {
  def rec(currentNode: Tree[A]): Seq[A] = {
    currentNode match {
      case Node(value, left, right) => rec(left) ++ rec(right) :+ value
      case _                        => Seq()
    }
  }
  rec(tree)
}

val nodes =
  Node(0,
    Node(1,
      Node(4, Empty, Empty),
      Node(2, Empty, Empty)
    ),
    Node(3,
      Node(5, Empty,
        Node(11, Empty, Empty)),
      Node(10, Empty, Empty)
    )
  )

//preOrder(nodes)
//postOrder(nodes)
//inOrder(nodes)

//https://stackoverflow.com/questions/12629721/coin-change-algorithm-in-scala-using-recursion
def coinChange(money: Int, coins: List[Int]): Int = {
  if (money == 0)
    1
  else if (money > 0 && coins.nonEmpty)
    coinChange(money - coins.head, coins) + coinChange(money, coins.tail)
  else
    0
}

// coinChange(10, List(1, 1, 2, 3, 4, 5, 5, 6, 7))


trait Adder[A] {
  def add(a: A, b: A): A
  def empty: A
}

class Simple {
  implicit val intAdder: Adder[Int] = new Adder[Int] {
    def add(a: Int, b: Int) = a + b
    def empty = 0
  }

  def sum[A](nums: List[A])(implicit adder: Adder[A]): A = {
    nums match {
      case Nil => adder.empty
      case head :: tail => adder.add(head, sum(tail))
    }
  }

  def main(args: Array[String]) = {
    println(sum(List(1, 2, 3, 4, 5)))
  }
}

def isOrdered[A](nums: List[A], ordering: (A, A) => Boolean): Boolean = {
  @tailrec
  def rec(nums: List[A]): Boolean = {
    nums match {
      case _ :: Nil       => true
      case x :: y :: Nil  => ordering(x, y)
      case x :: y :: tail => ordering(x, y) && rec(tail)
      case _              => false
    }
  }
  rec(nums)
}

isOrdered[Int](List(5, 4), (a, b) => a > b)

case class MyBool(a: Boolean) {
  def and(that: MyBool): MyBool =
    if (a) that else this

  def or(that: MyBool): MyBool =
    if (a) this else that

  def negate: MyBool = MyBool(!a)
}
def not(x: MyBool) = x.negate

/*
val b1 = MyBool(true)
val b2 = MyBool(true)

b1 or b2 and not(b1 and b2)

 */


def longestCommonPrefix(words: Array[String]): String = {

  def checkIfCharacterMatch(ch: Char, idx: Int, words: Array[String]): Boolean = {
    words.forall(word => word.charAt(idx) == ch)
  }

  def longestCommon(words: Array[String]): String = {
    if (words.length == 0) {
      ""
    } else if (words.length == 1) {
      words.head
    } else {
      val minLengthWord = words.minBy(_.length)

      if (minLengthWord == "")
        minLengthWord
      else {
        val maxIdxPair =
          minLengthWord.zipWithIndex
            .takeWhile{ pair =>
              checkIfCharacterMatch(pair._1, pair._2, words)
            }

        if (maxIdxPair.isEmpty) ""
        else {
          val maxIdx = maxIdxPair.last._2
          minLengthWord.substring(0, maxIdx + 1) // inclusive
        }
      }
    }
  }

  longestCommon(words)
}

// longestCommonPrefix(Array("rac", "dig"))

class Person(val name: String, val age: Int)
object Person {
  def apply(name: String = "", age: Int = -1) = new Person(name, age)
  def unapply(person: Person): Option[(String, Int)] = Some(person.name, person.age)
}

Person("john", 12) match {
  case Person(_, age) => s"${age} year old!"
}

def binarysearch(nums: List[Int], value: Int): Int = {
  @tailrec
  def rec(asd: List[Int], target: Int, start: Int, end: Int): Int= {
    if (start > end) -1
    else {
      val mid = (start + end) / 2

      asd(mid) match {
        case elem if elem > target  => rec(asd, target, start, mid - 1)
        case elem if elem == target => mid
        case _  => rec(asd, target, mid + 1, end)
      }
    }
  }
  rec(nums, value, 0, nums.length - 1)
}

//binarySearch(Seq(1, 2, 3, 4, 5, 6), 4)
binarysearch(List(1, 2, 3, 4, 5, 6), 4)
