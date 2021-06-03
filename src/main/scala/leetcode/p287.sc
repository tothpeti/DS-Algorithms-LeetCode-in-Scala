/*
Problem 287: Find the Duplicate Number
 */

def findDuplicate(nums: Array[Int]): Int = {
  nums.groupMapReduce(identity)(_ => 1)(_ + _)
    .find(_._2 > 1) match {
    case Some(value) => value._1
    case None        => 0
  }
}

findDuplicate(Array(3,1,3,4,2))
