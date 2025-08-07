object Task7 {
  def solution(nums: Array[Int]): Boolean = {
    var index = nums.head
    for (i <- nums.indices by index) {
      if(nums(i) != nums.last) index += i
    }
    index == nums.length-1
  }

  println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
  // Task 7 = true

  println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
  // Task 7 = false

  println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
  // Task 7 = true

}
