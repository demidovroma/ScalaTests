// Дано подмножество различных целых чисел.
// Верните все возможные подмножества (мощность множества).
//
// Примечание:
// - Множество решений не должно содержать повторяющихся подмножеств.

// Коммент от Глеба
// (a, b) - нейминг не нравится, вместо a - в таких случаях используем acc (accumulator)

def solution(nums: Array[Int]): List[List[Int]] = {

  nums.toList.foldLeft(List(List[Int]())) { (acc, b) =>
    acc ++ acc.map(b :: _)
  }

//  @tailrec
//  def subsets(n: Int, list: List[Int]): List[List[Int]] = list match {
//    if(n == 0)
//      List()
//    else
//
//    case Nil => List(Nil)
//    case x :: xs =>
//      val tailSubsets = subsets(n-1, xs)
//
//      tailSubsets ++ tailSubsets.map(x :: _)
//  }
//
//  subsets(nums.length, nums.toList)


  //nums.flatMap(i => nums.toList.combinations(i)).toList :+ List()



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
