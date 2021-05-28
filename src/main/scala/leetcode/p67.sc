/*
Problem 67: Add Binary

Given two binary strings 'a' and 'b' return their sum as a binary string
 */

def addBinary(a: String, b: String): String = {
  (BigInt(a, 2) + BigInt(b, 2)).toString(2)
}

addBinary("11", "1")
