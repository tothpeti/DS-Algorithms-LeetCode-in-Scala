def frequencySort(s: String): String = {
  s.groupMapReduce(e => e)(_ => 1)(_ + _)
    .toList
    .sortWith((pair1, pair2) => pair1._2 > pair2._2)
    .map(pair => pair._1.toString * pair._2)
    .mkString("")
}


frequencySort("Aabb")
