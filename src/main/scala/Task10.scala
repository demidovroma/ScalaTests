// Дана n x n 2D матрица (двумерный массив) представляющая изображение.
// Поверните изображение на 90 градусов (по часовой стрелке).
//
// Примечание:
// - Вы должны повернуть изображение на месте, что означает, что вы должны изменить входную 2D матрицу напрямую. НЕ выделяйте другую 2D матрицу.

import scala.annotation.tailrec

object Task10 {
  def solution(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val n = matrix.length

    // Рекурсия транспонирования
    @tailrec
    def transpose(i: Int, j: Int): Unit = {
      if (i < n) {
        if (j < n) {
          if (j > i) {
            val temp = matrix(i)(j)
            matrix(i)(j) = matrix(j)(i)
            matrix(j)(i) = temp
          }
          transpose(i, j + 1)
        } else {
          transpose(i + 1, i + 1)
        }
      }
    }

    // Рекурсия для переворота строки
    @tailrec
    def reverseRow(row: Array[Int], left: Int, right: Int): Unit = {
      if (left < right) {
        val temp = row(left)
        row(left) = row(right)
        row(right) = temp
        reverseRow(row, left + 1, right - 1)
      }
    }

    // Рекурсивный перебор строк для переворота
    @tailrec
    def reverseAllRows(i: Int): Unit = {
      if (i < n) {
        reverseRow(matrix(i), 0, n - 1)
        reverseAllRows(i + 1)
      }
    }

    transpose(0, 0)
    reverseAllRows(0)
    matrix
  }

  def printMatrix(matrix: Array[Array[Int]]): String = {
    matrix.map(_.mkString("", ", ", "")).mkString("\n", ",\n", "")
  }

  val matrix1: Array[Array[Int]] = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  val matrix2: Array[Array[Int]] = Array(
    Array(5, 1, 9, 11),
    Array(2, 4, 8, 10),
    Array(13, 3, 6, 7),
    Array(15, 14, 12, 16),
  )

  println(s"Task 10 = ${printMatrix(solution(matrix1))}")
  //Task 10 = Array(
  //  Array(7, 4, 1),
  //  Array(8, 5, 2),
  //  Array(9, 6, 3)
  //)

  println(s"Task 10 = ${printMatrix(solution(matrix2))}")
  //Task 10 = Array(
  //  Array(15, 13, 2, 5),
  //  Array(14, 3, 4, 1),
  //  Array(12, 6, 8, 9),
  //  Array(16, 7, 10, 11)
  //)

}
