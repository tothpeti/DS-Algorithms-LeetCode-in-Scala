/*
Problem 657: Robot Return to Origin
 */
def judgeCircle(moves: String): Boolean = {
  var x = 0
  var y = 0
  for (move <- moves) {
    val (moveX, moveY) = makeMove(move)
    x += moveX
    y += moveY
  }

  x == 0 && y == 0
}

def makeMove(move: Char): (Int, Int) = {
  move match {
    case 'U' => (1, 0)
    case 'D' => (-1, 0)
    case 'L' => (0, -1)
    case _   => (0, 1)
  }
}
