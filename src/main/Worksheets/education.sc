// Напиши метод, который принимает имя и возраст, и возвращает строку:
// "Привет, меня зовут <имя> и мне <возраст> лет"
// Используй val и String Interpolation.
def sayMyName(name: String, age: Int): String = {
  s"Привет, меня зовут $name и мне $age лет"
}
sayMyName("Roman", 38)

// Напиши метод multiply с двумя параметрами a и b (Int), который возвращает их произведение.
def multiply(a: Int, b: Int): Int = {
  a * b
}
multiply(2, 3)

// Напиши метод sumList, который принимает List[Int] и возвращает сумму всех элементов,
// используя функциональный стиль (.sum).
def sumList(nums: List[Int]): Int = {
  nums.sum
}
sumList(List(1,2,3,4,5))

// Напиши метод, который принимает имя и возвращает строку вида:
// "Привет, Roman! Твоё имя содержит 5 букв."
def lenghtName(name: String): String = {
  val lenght = name.length
  s"Привет, $name! Твоё имя содержит $lenght букв."
}
lenghtName("Roman")

// Напиши метод, который принимает List[Int] и число multiplier: Int,
// и возвращает новый список, где каждый элемент умножен на это число.
def multiplyList(nums: List[Int], target: Int): List[Int] = {
  nums.map(_ * target)
}
multiplyList(List(1, 2, 3), 2) // List(2, 4, 6)

// Напиши метод, который принимает список и возвращает его последний элемент.
//Если список пустой — возвращает "Список пуст" (через Option).
def lastElement(nums: List[Int]): Option[Int] = {
  nums.lastOption
}
lastElement(List(1, 2, 3))  // Some(3)
lastElement(List())         // None

// Напиши метод, который принимает список чисел и возвращает список квадратов только чётных чисел.
def evenSquares(nums: List[Int]): List[Int] = {
  nums.filter(_ % 2 == 0).map(n => n * n)
}
evenSquares(List(1, 2, 3, 4, 5, 6)) // List(4, 16, 36)

// Напиши метод, который принимает Option[String] и возвращает длину строки в Some.
//Если пришло None, то вернуть 0.
def stringLength(str: Option[String]): Int = {
  str.map(_.length).getOrElse(0)
}
stringLength(Some("Scala")) // 5
stringLength(None)          // 0

// Напиши метод, который принимает список строк и возвращает новый список,
// в котором все строки длиннее 3 символов преобразованы в UPPERCASE.
def longWordsToUpper(str: List[String]): List[String] = {
  str.filter(_.length > 3).map(_.toUpperCase)
}
longWordsToUpper(List("hi", "scala", "fun", "world")) // List("SCALA", "WORLD")

// Напиши метод, который принимает список чисел и возвращает их сумму.
def sumNumbers(nums: List[Int]): Int = {
  nums.sum
}
sumNumbers(List(1, 2, 3, 4)) // должно вернуть 10

// Напиши метод, который принимает список чисел
// и возвращает сумму только положительных.
def sumPositive(nums: List[Int]): Int = {
  nums.filter(_ > 0).sum
}
sumPositive(List(-5, 10, -3, 7)) // должно вернуть 17

// Напиши метод, который принимает список строк
// и возвращает сумму длин всех строк.
def sumStringLengths(words: List[String]): Int = {
  words.map(_.length).sum
}
sumStringLengths(List("Scala", "is", "fun")) // должно вернуть 10

////////////////////////////////////////////////////////////////////////////////////////////////
// День 2

// Если Option пустой — вернуть "?".
def getFirstOption (str: Option[String]): String = {
  str.flatMap(_.headOption.map(_.toString)).getOrElse("?")
}
getFirstOption(Some("Scala")) // должно вернуть "S"
getFirstOption(None)          // должно вернуть "?"

// Сумма двух Option[Int]
// Если значение отсутствует, считаем его как 0.
def sumOption(num1: Option[Int], num2: Option[Int]): Int = {
  num1.getOrElse(0) + num2.getOrElse(0)
}
sumOption(Some(10), Some(5)) // должно вернуть 15
sumOption(Some(7), None)     // должно вернуть 7
sumOption(None, None)        // должно вернуть 0

// Фильтрация чётных чисел из списка
def filterEven (nums: List[Int]): List[Int] = {
  nums.filter(_ % 2 == 0)
}
filterEven(List(1, 2, 3, 4, 5, 6)) // должно вернуть List(2, 4, 6)

// Умножение каждого элемента списка на заданное число
def multiplyMap(nums: List[Int], target: Int): List[Int] = {
  nums.map(_ * target)
}
multiplyMap(List(1, 2, 3), 3) // должно вернуть List(3, 6, 9)

// Нахождение максимума и минимума в списке
def maxComparator(nums: List[Int]): Int = {
  nums.max
}
maxComparator(List(5, 12, 3, 8)) // должно вернуть 12

def minComparator(nums: List[Int]): Int = {
  nums.min
}
minComparator(List(5, 12, 3, 8)) // должно вернуть 3

// Получить первую букву каждой строки в списке
// Пропускаем пустые строки
def firstChars(str: List[String]): List[Char] = {
  val chars = for {
    s <- str
    if s.nonEmpty
    t <- s.headOption
  } yield t
  chars
}
firstChars(List("scala", "is", "fun", "")) // должно вернуть List('s', 'i', 'f')

// Преобразовать все строки длиннее 3 символов в верхний регистр
longStringsToUpper(List("hi", "scala", "fun", "world")) // должно вернуть List("SCALA", "WORLD")

// Сумма положительных чисел в списке
sumPositive(List(-2, 5, -1, 7, 0)) // должно вернуть 12

// Умножение каждого числа списка на заданное число
multiplyListBy(List(1, 2, 3, 4), 3) // должно вернуть List(3, 6, 9, 12)

// Фильтровать строки, которые начинаются с буквы 'a' (регистронезависимо)
filterStartsWithA(List("apple", "Banana", "avocado", "Apricot", "berry"))
// должно вернуть List("apple", "avocado", "Apricot")