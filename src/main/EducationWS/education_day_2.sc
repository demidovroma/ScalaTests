// День 2

// 8 - List Sum Method

// 1️⃣ Дан список чисел, найти их сумму.
// Вход: List(5, 10, 15)
// Ожидаемый результат: 30
def sumNumbers(nums: List[Int]): Int = {
  nums.sum
}
sumNumbers(List(5, 10, 15)) // должно вернуть 30

// 2️⃣ Дан список чисел, найти сумму только отрицательных.
// Вход: List(3, -2, -7, 4)
// Ожидаемый результат: -9
def sumNegative(nums: List[Int]): Int = {
  nums.filter(_ < 0).sum
}
sumNegative(List(3, -2, -7, 4)) // должно вернуть -9

// 3️⃣ Дан список дробных чисел (Double), найти их сумму.
// Вход: List(1.5, 2.5, 3.0)
// Ожидаемый результат: 7.0
def sumDoubles(nums: List[Double]): Double = {
  nums.sum
}
sumDoubles(List(1.5, 2.5, 3.0)) // должно вернуть 7.0

// 9 — List Filter Method

// 1️⃣ Дан список чисел, выбрать только положительные.
// Вход: List(-3, 2, 0, 5, -1)
// Ожидаемый результат: List(2, 5)
def filterPositive(nums: List[Int]): List[Int] = {
  nums.filter(_ > 0)
}
filterPositive(List(-3, 2, 0, 5, -1)) // должно вернуть List(2, 5)

// 2️⃣ Дан список строк, выбрать только те, которые длиннее 3 символов.
// Вход: List("hi", "Scala", "AI", "fun")
// Ожидаемый результат: List("Scala", "fun")
def filterLongWords(str: List[String]): List[String] = {
  str.filter(_.length >= 3)
}
filterLongWords(List("hi", "Scala", "AI", "fun")) // должно вернуть List("Scala", "fun")

// 3️⃣ Дан список чисел, выбрать только числа, кратные 5.
// Вход: List(5, 12, 15, 20, 7)
// Ожидаемый результат: List(5, 15, 20)
def filterMultiplesOfFive(nums: List[Int]): List[Int] = {
  nums.filter(_ % 5 == 0)
}
filterMultiplesOfFive(List(5, 12, 15, 20, 7)) // должно вернуть List(5, 15, 20)

// 10 - Map for List

// 1️⃣ Дан список чисел, умножить каждое на 10.
// Вход: List(1, 2, 3)
// Ожидаемый результат: List(10, 20, 30)
def mapMultiply10(nums: List[Int]): List[Int] = {
  nums.map(_ * 10)
}
mapMultiply10(List(1, 2, 3)) // должно вернуть List(10, 20, 30)

// 2️⃣ Дан список слов, преобразовать каждое в верхний регистр.
// Вход: List("scala", "is", "fun")
// Ожидаемый результат: List("SCALA", "IS", "FUN")
def mapToUpper(str: List[String]): List[String] = {
  str.map(_.toUpperCase)
}
mapToUpper(List("scala", "is", "fun")) // должно вернуть List("SCALA", "IS", "FUN")

// 3️⃣ Дан список чисел, вернуть их квадраты.
// Вход: List(2, 3, 4)
// Ожидаемый результат: List(4, 9, 16)
def mapSquares(nums: List[Int]): List[Int] = {
  nums.map(n => n * n)
}
mapSquares(List(2, 3, 4)) // должно вернуть List(4, 9, 16)

// 11 - List Flatten

// 1️⃣ Дан список списков чисел, объединить их в один список
// Вход: List(List(1,2), List(3,4), List(5))
// Ожидаемый результат: List(1,2,3,4,5)
def flattenNumbers(nums: List[List[Int]]): List[Int] = {
  nums.flatten
}
flattenNumbers(List(List(1,2), List(3,4), List(5))) // должно вернуть List(1,2,3,4,5)

// 2️⃣ Дан список списков строк, объединить их в один список
// Вход: List(List("a","b"), List("c"), List("d","e"))
// Ожидаемый результат: List("a","b","c","d","e")
def flattenStrings(str: List[List[String]]): List[String] = {
  str.flatten
}
flattenStrings(List(List("a","b"), List("c"), List("d","e"))) // должно вернуть List("a","b","c","d","e")

// 3️⃣ Дан список списков чисел, объединить и оставить только положительные числа
// Вход: List(List(1,-2), List(-3,4), List(0,5))
// Ожидаемый результат: List(1,4,5)
def flattenPositive(nums: List[List[Int]]): List[Int] = {
  nums.flatten.filter(_ > 0)
}
flattenPositive(List(List(1,-2), List(-3,4), List(0,5))) // должно вернуть List(1,4,5)

// 12 - flatMap

// 1️⃣ Дан список чисел, создать для каждого число список [n, n*2, n*3]
// Вход: List(1,2,3)
// Ожидаемый результат: List(1,2,3,2,4,6,3,6,9)
def flatMapMultiples(nums: List[Int]): List[Int] = {
  nums.flatMap(n => List(n, n * 2, n*3))
}
flatMapMultiples(List(1,2,3)) // должно вернуть List(1,2,3,2,4,6,3,6,9)

// 2️⃣ Дан список строк, для каждой строки создать список её символов
// Вход: List("hi", "Scala")
// Ожидаемый результат: List('h','i','S','c','a','l','a')
def flatMapChars(str: List[String]): List[Char] = {
  str.flatMap(_.toSeq)
}
flatMapChars(List("hi","Scala")) // должно вернуть List('h','i','S','c','a','l','a')

// 3️⃣ Дан список списков чисел, вернуть один список, где каждый элемент увеличен на 1
// Вход: List(List(1,2), List(3,4))
// Ожидаемый результат: List(2,3,4,5)
def flatMapIncrement(nums: List[List[Int]]): List[Int] = {
  nums.flatMap(n => n.map(_ + 1))
}
flatMapIncrement(List(List(1,2), List(3,4))) // должно вернуть List(2,3,4,5)

// 13 — foldLeft

// 1️⃣ Сумма всех чисел в списке
// Вход: List(5, 10, 15)
// Ожидаемый результат: 30
def sumFold(nums: List[Int]): Int = {
  nums.foldLeft(0)(_ + _)

}
sumFold(List(5, 10, 15)) // должно вернуть 30

// 2️⃣ Конкатенация списка строк через пробел
// Вход: List("Hello", "Scala", "World")
// Ожидаемый результат: "Hello Scala World"
def concatFold(str: List[String]): String = {
  str.foldLeft("") {
    (acc, s) =>
      if (acc.isEmpty) s
      else acc + " " + s
    }
}
concatFold(List("Hello", "Scala", "World")) // должно вернуть "Hello Scala World"

// 3️⃣ Найти произведение всех чисел в списке
// Вход: List(2, 3, 4)
// Ожидаемый результат: 24
def productFold(nums: List[Int]): Int = {
  nums.foldLeft(1){
    (acc, n) =>
      acc * n
  }
}
productFold(List(2, 3, 4)) // должно вернуть 24

// 14 - for-comprehension

// 1️⃣ Дан список чисел, вернуть список их квадратов, если число > 3
// Вход: List(1,2,3,4,5)
// Ожидаемый результат: List(16, 25)
def forSquares(nums: List[Int]): List[Int] = {
  val res = for {
    n <- nums
    if n > 3
  } yield n * n
  res
}
forSquares(List(1,2,3,4,5)) // должно вернуть List(16, 25)

// 2️⃣ Дан список строк, вернуть список первых букв всех слов длиной > 2, в верхнем регистре
// Вход: List("hi", "scala", "fun", "AI")
// Ожидаемый результат: List('S', 'F')
def firstCharsUpper(str: List[String]): List[Char] = {
  val res = for {
    s <- str
    if s.length > 2
    c <- s.headOption
  } yield c.toUpper
  res
}
firstCharsUpper(List("hi", "scala", "fun", "AI")) // должно вернуть List('S', 'F')

// 3️⃣ Даны два списка чисел, вернуть список всех сумм пар чисел (один из первого, один из второго), если сумма > 5
// Вход: List(1,2), List(3,4)
// Ожидаемый результат: List(5,6)
def sumPairsFiltered(nums_one: List[Int], nums_two: List[Int]): List[Int] = {
  val res = for {
    a <- nums_one
    b <- nums_two
    sum = a + b
    if sum > 5
  } yield sum
  res
}
sumPairsFiltered(List(1,2), List(3,4)) // должно вернуть List(6)
