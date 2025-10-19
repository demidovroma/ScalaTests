import scala.annotation.tailrec

// List Sum Method
// 1. Найти сумму всех положительных чисел в списке.
def sumPositive(nums: List[Int]): Int = {
  nums.filter(_ > 0).sum
}
sumPositive(List(-1,2,3,-5)) // 5

// 2. Найти сумму квадратов всех чисел больше 3.
def sumSquaresGreaterThan3(nums: List[Int]): Int = {
  nums.filter(_ > 3).map(n => n * n).sum
}
sumSquaresGreaterThan3(List(1,4,5)) // 41

// 3. Найти сумму длин строк, начинающихся с буквы "S".
def sumLengthsS(words: List[String]): Int = {
  words.filter(_.startsWith("S")).map(_.length).sum
}
sumLengthsS(List("Scala","java","Spark")) // 10

// 4. Сумма элементов с чётными индексами.
def sumEvenIndex(nums: List[Int]): Int = {
  nums.zipWithIndex.collect { case (value, index) if index % 2 == 0 => value }.sum
}
sumEvenIndex(List(1,2,3,4,5)) // 9

// 5. Найти сумму элементов, которые делятся на 3 или 5.
def sumDiv3or5(nums: List[Int]): Int = {
  nums.filter(n => n % 3 == 0 || n% 5 == 0).sum
}
sumDiv3or5(List(1,3,5,6,7,10)) // 24

// List Filter Method
// 6. Оставить числа, которые делятся на 4 и больше 10.
def filterDiv4gt10(nums: List[Int]): List[Int] = {
  nums.filter(n => n % 4 == 0 && n > 10)
}
filterDiv4gt10(List(4,8,12,16)) // List(12,16)

// 7. Отфильтровать строки длиной от 2 до 5 символов.
def filterLength2to5(words: List[String]): List[String] = {
  words.filter(s => s.length >=  2 && s.length <= 5)
}
filterLength2to5(List("a","ab","abcdef","hey")) // List("ab","hey")

// 8. Оставить только уникальные отрицательные числа.
def uniqueNegatives(nums: List[Int]): List[Int] = {
  nums.toSet.toList.filter(_ < 0)
}
uniqueNegatives(List(-1,-2,-1,3,-2)) // List(-1,-2)

// 9. Убрать элементы, которые встречаются более одного раза.
def removeDuplicates(nums: List[Int]): List[Int] = {
  @tailrec
  def loop(remaining: List[Int], acc: List[Int]): List[Int] = remaining match {
    case Nil => acc.reverse
    case x :: xs =>
      if (remaining.count(_ == x) == 1) loop(xs, x :: acc)
      else loop(xs.filter(_ != x), acc)
  }

  loop(nums, Nil)
}
removeDuplicates(List(1,2,2,3,3,4)) // List(1,4)

// 10. Оставить числа, которые являются простыми.
def filterPrimes(nums: List[Int]): List[Int] = {
  def isPrime(n: Int): Boolean =
    n > 1 && (2 until n).forall(n % _ != 0)

  nums.filter(isPrime)
}
filterPrimes(List(1,2,3,4,5,6)) // List(2,3,5)
