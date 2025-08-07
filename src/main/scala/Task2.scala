// Определите, является ли целое число палиндромом.
//
// Примечание:
// - Целое число является палиндромом, когда оно читается назад также как и вперед.
// - Постарайтесь решить задачу без преобразования числа в строку.

object Task2 {
  def solution(x: Int): Boolean = {

    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    val digit = LazyList.iterate(x)(n => n / 10).takeWhile(_ > 0).map(n => n % 10).toList
    digit == digit.reverse

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