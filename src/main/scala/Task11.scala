// Successful

// Дан набор различных целых чисел.
// Верните все возможные перестановки.

object Task11 {
  def solution(nums: Array[Int]): List[List[Int]] = {

    nums.toList.permutations.toList

  }

  println(s"Task 11 = ${solution(Array(1, 2, 3))}")
  // Task 11 = List(
  //   List(1, 2, 3),
  //   List(1, 3, 2),
  //   List(2, 1, 3),
  //   List(2, 3, 1),
  //   List(3, 1, 2),
  //   List(3, 2, 1)
  // )
}
