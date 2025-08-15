// Дан массив неотрицательных целых чисел, где вы изначально располагаетесь на начальном индексе массива.
// Каждый элемент массива представляет вашу максимальную длину прыжка в этой позиции.
// Определите, сможете ли вы достичь последнего индекса.

// Task 7: Var стараемся не использовать.
// Можно записать либо через комбинатор (foldLeft), либо через хвостовую рекурсию. -

import scala.annotation.tailrec




var nums = Array(2, 3, 1, 1, 4)

def solution(nums: Array[Int]): Boolean = {

  0 == (nums.length - 1 to (0, -1)).foldLeft(nums.length - 1)((a, b) =>
    if (nums(b) + b >= a) b else a
  )

//  nums.indices.foldLeft(nums(0)) { (maxReach, index) =>
//    println("maxReach (val) = " + maxReach)
//    println(" - ")
//    println("index = " + index)
//    println("index + nums(index) = " + (index + nums(index)))
//    println(" *** ")
//
//    if (maxReach < index) 0 // Если текущая позиция недостижима, возвращаем 0
//    else if (maxReach >= nums.length - 1) nums.length-1 // Если уже достигли конца, останавливаемся
//    else Math.max(maxReach, index + nums(index)) // Обновляем максимальную достижимую позицию
//
//  } == nums.length - 1
}

// Тестовые случаи
println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}") // true
println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}") // false
println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}") // true

def solution(nums: Array[Int]): Boolean = {
  nums.indices.foldLeft(0) { (maxReach, i) =>
    if (maxReach < i) 0  // Маркируем невозможность достижения
    else Math.max(maxReach, i + nums(i))
  } >= nums.length - 1
}

// Проверка условий
println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")  // true
println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")  // false
println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")  // true





//@tailrec
//def loop(n: Int, accumulator: Int): Int = {
//  if (n == 0)
//    accumulator/10
//  else
//    loop(n / 10, (accumulator + n % 10) * 10)
//}
//
//loop(1, 0)



//def solution(nums: Array[Int]): Boolean = {
//  for (i <- nums.indices by 0) {
//    if(nums(i) != nums.last) 0 += i
//  }
//  nums.last == nums.length-1
//}
//
//println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
//// Task 7 = true
//
//println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
//// Task 7 = false
//
//println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
//// Task 7 = true

