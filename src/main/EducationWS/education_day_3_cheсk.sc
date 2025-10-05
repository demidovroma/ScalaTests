import scala.util.Try

// 1️⃣ Создать val и var, изменить var, вывести их значения
// val city = "Warsaw", var country = "Poland"
// Ожидаемый результат: city = "Warsaw", country = "Germany"
val city = "Warsaw"
var country = "Germany"

// 2️⃣ Создать lazy val, вывести его дважды и посмотреть, что вычисление происходит один раз
// lazy val randomNumber = scala.util.Random.nextInt(100)
// Ожидаемый результат: сообщение о вычислении появляется только один раз
lazy val randomNumber = scala.util.Random.nextInt(100)
randomNumber
randomNumber

// 3️⃣ Метод без аргументов, который возвращает приветствие
// greet() // должно вернуть "Hello, Scala!"
def greet(): String = {
  val greet = "Hello, Scala!"
  greet
}
greet()

// 4️⃣ Метод с аргументами, который возвращает строку с именем и возрастом
// personInfo("Alice", 30) // должно вернуть "Alice is 30 years old"
def personInfo(name: String, age: Int): String = {
  s"$name is $age years old"
}
personInfo("Alice", 30)

// 5️⃣ Точка входа main, которая выводит сумму чисел в списке
// main(Array(1,2,3,4)) // должно вывести 10
def main(num: Array[Int]): Int = {
  num.sum
}
main(Array(1,2,3,4))

// 6️⃣ Суммировать элементы списка целых чисел
// sumList(List(5,10,15)) // должно вернуть 30
def sumList(nums: List[Int]): Int = {
  nums.sum
}
sumList(List(5,10,15))

// 7️⃣ Отфильтровать список чисел, оставив только чётные
// filterEven(List(1,2,3,4,5)) // должно вернуть List(2,4)
def filterEven(nums: List[Int]): List[Int] = {
  nums.filter(_ % 2 == 0)
}
filterEven(List(1,2,3,4,5))

// 8️⃣ Применить map к списку строк, преобразовав их в верхний регистр
// mapToUpper(List("scala","fun")) // должно вернуть List("SCALA","FUN")
def mapToUpper(str: List[String]): List[String] = {
  str.map(_.toUpperCase)
}
mapToUpper(List("scala","fun"))

// 9️⃣ "Выпрямить" вложенный список чисел
// flattenList(List(List(1,2), List(3,4))) // должно вернуть List(1,2,3,4)
def flattenList(listNums: List[List[Int]]): List[Int] = {
  listNums.flatten
}
flattenList(List(List(1,2), List(3,4)))

// 1️⃣0️⃣ Применить flatMap к списку строк, разбив их на символы
// flatMapChars(List("hi","ok")) // должно вернуть List('h','i','o','k')
def flatMapChars(str: List[String]): List[Char] = {
  str.flatMap(_.toSeq)
}
flatMapChars(List("hi","ok"))

// 1️⃣1️⃣ Вычислить сумму списка чисел с помощью foldLeft
// sumFold(List(2,3,4)) // должно вернуть 9
def sumFold(nums: List[Int]): Int = {
  nums.foldLeft(0)(_ + _)
}
sumFold(List(2,3,4))

// 1️⃣2️⃣ for-comprehension: получить квадраты чисел больше 3
// squaresFiltered(List(1,2,3,4,5)) // должно вернуть List(16,25)
def squaresFiltered(nums: List[Int]): List[Int] = {
  val res = for {
    a <- nums
    if a > 3
  } yield a * a
  res
}
squaresFiltered(List(1,2,3,4,5))

// 1️⃣3️⃣ Option: получить первую букву строки, если она есть
// firstChar(Some("scala")) // должно вернуть 'S'
// firstChar(None)          // должно вернуть '?'
def firstChar(str: Option[String]): Option[Char] = str match {
  case Some(s) => s.toUpperCase.headOption
  case _ => Some('?')
}
firstChar(Some("scala"))
firstChar(None)

// 1️⃣4️⃣ Option map: умножить Option[Int] на 3
// multiplyOption(Some(4))  // должно вернуть Some(12)
// multiplyOption(None)     // должно вернуть None
def multiplyOption(num: Option[Int]): Option[Int] = num match {
  case Some(s) => Some(s * 3)
  case _       => None
}
multiplyOption(Some(4))
multiplyOption(None)

// 1️⃣5️⃣ Try: безопасно разделить два числа
// safeDivide(10, 2) // должно вернуть Success(5)
// safeDivide(10, 0) // должно вернуть Failure(java.lang.ArithmeticException)
def safeDivide(a: Int, b: Int): Try[Int] = {
  Try {
    a / b
  }
}
safeDivide(10, 2)
safeDivide(10, 0)

// 1️⃣6️⃣ Either: вернуть Right(число) если положительное, Left(ошибка) если отрицательное
// checkPositive(5)   // должно вернуть Right(5)
// checkPositive(-3)  // должно вернуть Left("Отрицательное число")
def checkPositive(n: Int): Either[String, Int] = {
  if (n > 0) Right(n)
  else Left("Отрицательное число")
}
checkPositive(5)
checkPositive(-3)