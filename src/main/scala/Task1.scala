// Дан массив чисел и целевое значение.
// Напишите программу, которая будет возвращать индексы 2 чисел, сумма которых равна целевому значению.
//
// Примечание:
// - Для каждого набора входных данных может быть только одно решение
// - Нельзя использовать один и тот же элемент массива дважды

import scala.annotation.tailrec

object Task1 {

  def solution(nums: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def loop(i: Int, indexByNum: Map[Int, Int]): Array[Int] = {
      if (i < 0) Array(-1, -1)
      else {
        if (indexByNum.contains(target-nums(i))) {
          Array(indexByNum(target-nums(i)), i)
        } else {
          loop(i - 1, indexByNum.updated(nums(i), i))
        }
      }
    }

    loop(nums.length-1, Map[Int, Int]())
  }

  println(s"Task 1 = ${solution(Array(2, 7, 11, 15), 9).toList}")
  // Task 1 = List(0, 1)

  println(s"Task 1 = ${solution(Array(3, 2, 4), 6).toList}")
  // Task 1 = List(1, 2)

  println(s"Task 1 = ${solution(Array(3, 3), 6).toList}")
  // Task 1 = List(0, 1)

  println(s"Task 1 = ${solution(Array(3, 3, 2), 6).mkString("Array(", ", ", ")")}")
  // Task 1 = List(1, 0)
}
