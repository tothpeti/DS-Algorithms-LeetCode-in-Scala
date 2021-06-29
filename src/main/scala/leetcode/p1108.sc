def defangIPaddr(address: String): String = {
  /* VERSION 1
   address.split("\\.").mkString("[.]")
   */

  // Version 2
  address.foldLeft(""){ (acc, curr) =>
    if (curr == '.') acc + "[.]"
    else acc + curr
  }
}