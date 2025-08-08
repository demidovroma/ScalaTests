// Определите, является ли целое число палиндромом.
//
// Примечание:
// - Целое число является палиндромом, когда оно читается назад также как и вперед.
// - Постарайтесь решить задачу без преобразования числа в строку.

import scala.annotation.tailrec

object Task2 {
  def solution(x: Int): Boolean = {
    @tailrec
    def loop(n: Int, accumulator: Int): Int = {
      if (n == 0)
        accumulator/10
      else
        loop(n / 10, (accumulator + n % 10) * 10)
    }

    if(x > 0)
      loop(x, 0) == x
    else
      false
  }

  println(s"Task 2 = ${solution(121)}")
  // Task 2 = true

  println(s"Task 2 = ${solution(-121)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(10)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(-101)}")
  // Task 2 = false

  println(s"Task 2 = ${solution(11)}")
  // Task 2 = true
}