// Дана n x n 2D матрица (двумерный массив) представляющая изображение.
// Поверните изображение на 90 градусов (по часовой стрелке).
//
// Примечание:
// - Вы должны повернуть изображение на месте, что означает, что вы должны изменить входную 2D матрицу напрямую. НЕ выделяйте другую 2D матрицу.

object Task10 {
  def solution(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    val n = matrix.length

    // Транспонируем матрицу
    for (i <- 0 until n) {
      for (j <- i until n) {
        val temp = matrix(i)(j)
        matrix(i)(j) = matrix(j)(i)
        matrix(j)(i) = temp
      }
    }

    // Отражаем каждую строку
    for (i <- 0 until n) {
      for (j <- 0 until n / 2) {
        val temp = matrix(i)(j)
        matrix(i)(j) = matrix(i)(n - 1 - j)
        matrix(i)(n - 1 - j) = temp
      }
    }

    matrix
  }

  val matrix1 = Array(
    Array(1, 2, 3),
    Array(4, 5, 6),
    Array(7, 8, 9)
  )

  val matrix2 = Array(
    Array(5, 1, 9, 11),
    Array(2, 4, 8, 10),
    Array(13, 3, 6, 7),
    Array(15, 14, 12, 16),
  )

  println(s"Task 10 = ${solution(matrix1)}")
  //Task 10 = Array(
  //  Array(7, 4, 1),
  //  Array(8, 5, 2),
  //  Array(9, 6, 3)
  //)

  println(s"Task 10 = ${solution(matrix2)}")
  //Task 10 = Array(
  //  Array(15, 13, 2, 5),
  //  Array(14, 3, 4, 1),
  //  Array(12, 6, 8, 9),
  //  Array(16, 7, 10, 11)
  //)

}
