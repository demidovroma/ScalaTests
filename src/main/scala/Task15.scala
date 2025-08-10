// Дана 2D сеточная карта, состоящая из "1" (земля) и "0" (вода).
// Подсчитайте количество островов.
// Остров окружен водой и образован соединением соседних земель по горизонтали или вертикали.
//
// Примечание:
// - Все четыре края сетки окружены водой.

object Task15 {
  def solution(grid: Array[Array[Char]]): Int = {
    def dfs(x: Int, y: Int): Unit = {
      if (x < 0 || x >= grid.length ||
        y < 0 || y >= grid(0).length ||
        grid(x)(y) == '0') {
        return
      }

      // Помечаем посещенную землю как воду
      grid(x)(y) = '0'

      // Рекурсивно посещаем соседние клетки
      dfs(x + 1, y) // вниз
      dfs(x - 1, y) // вверх
      dfs(x, y + 1) // вправо
      dfs(x, y - 1) // влево
    }

    def countIslands(i: Int, j: Int, count: Int): Int = {
      if (i >= grid.length) return count
      if (j >= grid(0).length) return countIslands(i + 1, 0, count)

      val newCount =
        if (grid(i)(j) == '1') {
          dfs(i, j)
          count + 1
        } else {
          count
        }

      countIslands(i, j + 1, newCount)
    }

    countIslands(0, 0, 0)
  }

  val grid1 = Array(
    Array('1','1','1','1','0'),
    Array('1','1','0','1','0'),
    Array('1','1','0','0','0'),
    Array('0','0','0','0','0')
  )

  println(s"Task 15 = ${solution(grid1)}")
  // Task 15 = 1

  val grid2 = Array(
    Array('1','1','0','0','0'),
    Array('1','1','0','0','0'),
    Array('0','0','1','0','0'),
    Array('0','0','0','1','1')
  )

  println(s"Task 15 = ${solution(grid2)}")
  // Task 15 = 3
}
