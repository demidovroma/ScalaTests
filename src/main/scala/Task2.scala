object Task2 {
  def solution(x: Int): Boolean = {
    if (x < 0) return false

    var num = x
    var revers = 0

    while (num != 0) {
      val lastDigit = num % 10
      revers = revers * 10
      revers += lastDigit
      num /= 10
    }

    x == revers
  }

  println(s"Task 2 = ${solution(121)}")
  // Task 2 = true

  println(s"Task 2 = ${solution(-121)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(10)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(-101)}")
  // Task 2 = false
}