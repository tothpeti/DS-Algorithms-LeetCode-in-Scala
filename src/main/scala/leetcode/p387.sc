import scala.collection.mutable

def firstUniqChar(s: String): Int = {
  val map: Map[Char, Int] =
    s.groupMapReduce(e => e)(_ => 1)(_ + _)

  def findIdx(index: Int): Int = {
    if (index >= s.length) -1
    else if (map(s(index)) == 1) index
    else findIdx(index + 1)
  }
  findIdx(0)
}

firstUniqChar("aadadaad")
