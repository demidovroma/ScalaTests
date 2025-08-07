object Task4 {
  def solution(nums: Array[Int], target: Int): Int = {
    nums.indexOf(target)
  }

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")
  // Task 4 = 4

  println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")
  // Task 4 = -1

  println(s"Task 4 = ${solution(Array(1), 0)}")
  // Task 4 = -1
}
