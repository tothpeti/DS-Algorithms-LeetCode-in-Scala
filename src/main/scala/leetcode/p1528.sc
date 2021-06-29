def restoreString(s: String, indices: Array[Int]): String = {
  (s zip indices)
    .sortBy(_._2)
    .foldLeft("")((acc, curr) => acc + curr._1)
}

restoreString("codeleet", Array(4,5,6,7,0,2,1,3))