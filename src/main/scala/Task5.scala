// Дано подмножество различных целых чисел.
// Верните все возможные подмножества (мощность множества).
//
// Примечание:
// - Множество решений не должно содержать повторяющихся подмножеств.

object Task5 {
  def solution(nums: Array[Int]): List[List[Int]] = {
    nums.toList.foldLeft(List(List[Int]())) { (acc, b) =>
      acc ++ acc.map(b :: _)
    }
  }

  println(s"Task 5 = ${solution(Array(1, 2, 3))}")
  // Task 5 = List(
  //   List(3),
  //   List(1),
  //   List(2),
  //   List(1, 2, 3),
  //   List(1, 3),
  //   List(2, 3),
  //   List(1, 2),
  //   List()
  // )

  println(s"Task 5 = ${solution(Array(4, 5, 3))}")
}
