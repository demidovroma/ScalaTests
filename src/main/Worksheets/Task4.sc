// Предположим дан массив чисел отсортированный по возрастанию,
// и затем повернутый в некоторой опорной точке неизвестной вам заранее (т.е., [0,1,2,4,5,6,7] может стать [4,5,6,7,0,1,2]).
// И вам дано целевое значение для поиска.
// Если найдено это значение, то вернуть его индекс, в противном случае вернуть -1.
//
// Примечание:
// - В массиве нет дубликатов.
// - Сложность времени выполнения вашего алгоритма должна быть порядка O(log n).

// Коммент от Глеба
// Можно просто
//val centerIndex = (leftSide + rightSide) / 2
//вместо
//val centerIndex = leftSide + (rightSide - leftSide) / 2

import scala.annotation.tailrec

  def solution(nums: Array[Int], target: Int): Int = {
    @tailrec
    def search(leftSide: Int, rightSide: Int): Int =

      if (leftSide > rightSide)
        -1
      else {
        val centerIndex = leftSide + (rightSide - leftSide) / 2

        if (nums(centerIndex) == target)
          centerIndex
        else if (nums(leftSide) <= nums(centerIndex))
          if (nums(leftSide) <= target && target < nums(centerIndex))
            search(leftSide, centerIndex - 1)
          else
            search(centerIndex + 1, rightSide)
        else
          if (nums(centerIndex) < target && target <= nums(rightSide))
            search(centerIndex + 1, rightSide)
          else
            search(leftSide, centerIndex - 1)
      }

    search(0, nums.length - 1)
  }

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")
  // Task 4 = 4

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")
  // Task 4 = -1

  println(s"Task 4 = ${solution(Array(1), 0)}")
  // Task 4 = -1

