
// Если больше 10 - умножить на 2, остальные пропустить
def transform(nums: List[Int]): List[Int] = {
  nums.collect {
    case n if n > 10 => n * 2
    case n => n
  }
}

val nums = List(5, 12, 8, 20)
transform(nums) // должно вернуть List(5, 24, 8, 40)

////
// Если первая буква "a" в любом регистре - всё слово в верхний регистр
def filterA(words: List[String]): List[String] = {
  words.filter(_.headOption.exists(_.toLower == 'a')).map(_.toUpperCase)
}

val words = List("apple", "Banana", "avocado", "Apricot", "berry")
println(filterA(words)) // должно вернуть List("APPLE", "AVOCADO", "APRICOT")

////
// Если не четные и больше 5 - в квадрат
def getOddSquaresGreaterThanFive(nums: List[Int]): List[Int] = {
  for (
    n <- nums if n % 2 != 0 && n > 5
  ) yield n * n
}

val nums = List(1,2,3,6,7,8,9)
println(getOddSquaresGreaterThanFive(nums)) // должно вернуть List(36, 49, 81)

////
// Если делится на 3 или на 5 - суммировать
def sumMultiplesOfThreeAndFive (nums: List[Int]) = {
  nums.filter(n => n % 3 == 0 || n % 5 == 0).sum
}

val nums = List(1,2,3,4,5,6,7,8,9,10)
println(sumMultiplesOfThreeAndFive(nums)) // должно вернуть 33

////
// Больше или равно 3 буквам - вернуть первую буквы в верхнем регистре.
def getFirstLetter (words: List[String]): List[String] = {
  words.filter(_.length >= 3).map(_.head.toString.toUpperCase)
}

val words = List("scala", "is", "fun", "AI")
println(getFirstLetter(words)); // должно вернуть List(S, F)

////
// Четные в квадрат
def toQuatro (nums: List[Int]): List[Int] = {
  nums.filter(_ % 2 == 0).map(n => n * n)
}

val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
println(toQuatro(nums)); // должно вернуть List(4, 16, 36, 64, 100)

////
// Больше 5 букв - в верхний регистр
def getString (input: List[String]): List[String] = {
  input.filter(_.length >= 5).map(_.toUpperCase)
}

val input = List("cat", "hello", "world", "scala", "a")
println(getString(input)); // должен вернуть List("HELLO", "WORLD", "SCALA")

////
// Если делится на 3 - умножить на 10
def getnums (nums: List[Int]): List[Int] = {
  nums.filter(_ % 3 == 0).map(_ * 10)
}

val nums = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
println(getnums(nums)); // должен вернуть List(30, 60, 90)

////
// Если четное - умножить на 2, остальные пропустить
def doubleEvens (nums: List[Int]): List[Int] = {
  nums.collect {
    case n if n % 2 == 0 => n * 2
    case n => n
  }
}

val nums = List(1, 2, 3, 4, 5)
println(doubleEvens(nums)); // должен вернуть List(1, 4, 3, 8, 5)

////
// Если не None - первую букву в верхний регистр
def firstCharUpper(words: List[Option[String]]): List[Char] = {
  words.flatten.filter(_.nonEmpty).map(_.head.toUpper)
}

val words: List[Option[String]] = List(Some("scala"), None, Some("play"), Some(""), Some("AI"))
firstCharUpper(words) // должно вернуть List('S', 'P', 'A')

////



object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val result: Array[Int] = nums.indices
      .flatMap(i => nums.indices.collect {
        case j
          if i != j && nums(i) + nums(j) == target =>
          Array(i, j)
      })
      .headOption
      .getOrElse(Array())

    result
  }
}

val nums = Array(2, 7, 11, 15)
val target = 9;
println(Solution.twoSum(nums, target).mkString("[", ", ", "]"))