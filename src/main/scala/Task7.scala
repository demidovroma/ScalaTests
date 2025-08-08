// Дан массив неотрицательных целых чисел, где вы изначально располагаетесь на начальном индексе массива.
// Каждый элемент массива представляет вашу максимальную длину прыжка в этой позиции.
// Определите, сможете ли вы достичь последнего индекса.

object Task7 {
  def solution(nums: Array[Int]): Boolean = {
    nums.indices.foldLeft(nums(0)) { (max, index) =>
      if (max < index) 0
      else if (max >= nums.length - 1) nums.length-1
      else Math.max(max, index + nums(index))
    } == nums.length-1
  }

  println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
  // Task 7 = true

  println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
  // Task 7 = false

  println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
  // Task 7 = true

}
