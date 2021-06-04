import scala.collection.mutable

/*
Problem 547: Number Of Provinces
 */

def findCircleNum(isConnected: Array[Array[Int]]): Int = {
  val numberOfNodes = isConnected.length

  val visited = Array.ofDim[Boolean](numberOfNodes)
  val queue = mutable.Queue[Int]()

  var numOfProvinces = 0

  for (i <- 0 until numberOfNodes) {
    if (!visited(i)) {
      queue.enqueue(i)
      numOfProvinces += 1

      while (queue.nonEmpty) {
        val x = queue.dequeue()
        visited(x) = true

        for (j <- 0 until numberOfNodes) {
          if (isConnected(x)(j) == 1 && !visited(j)){
            queue.enqueue(j)
          }
        }
      }
    }
  }
  numOfProvinces
}

val provinces = Array(
  Array(1, 0, 0),
  Array(0, 1, 0),
  Array(0, 0, 1)
)

findCircleNum(provinces)
