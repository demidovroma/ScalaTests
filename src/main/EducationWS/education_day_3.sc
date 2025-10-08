import scala.util.Try
// День 3
// 15 - Option
// Option — это контейнер, который может содержать либо значение (Some(value)), либо ничего (None).
// Используется для безопасной работы с возможным отсутствием значения,
// чтобы избежать NullPointerException.

// 1️⃣ Дан Option[String], вернуть первую букву в верхнем регистре, если значение есть, иначе "?"
// Пример вызова: firstChar(Some("scala")) // должно вернуть "S"
// Пример вызова: firstChar(None)          // должно вернуть "?"
def firstChar(str: Option[String]): Char = str match {
  case Some(s) => s.toUpperCase.headOption.getOrElse('?')
  case _ => '?'
}
firstChar(Some("scala")) // должно вернуть "S"
firstChar(Some(""))      // должно вернуть "?"
firstChar(None)          // должно вернуть "?"

// 2️⃣ Дан Option[Int] и число multiplier: Int, вернуть произведение значения на multiplier,
// если значение есть, иначе 0
def multiplyOption(num: Option[Int], target: Int): Int = num match {
  case Some(n) => n * target
  case None => 0
}
multiplyOption(Some(5), 3) // должно вернуть 15
multiplyOption(None, 3)    // должно вернуть 0

// 3️⃣ Дан список Option[Int], вернуть сумму всех значений, отсутствующие элементы считать за 0
// Пример вызова: sumOptions(List(Some(3), None, Some(7))) // должно вернуть 10
def sumOptions(nums: List[Option[Int]]): Int = {
  nums.map {
    case Some(n) => n
    case None    => 0
  }.sum
}
sumOptions(List(Some(3), None, Some(7))) // должно вернуть 10

// 16 - Option map
// Option.map позволяет безопасно применить функцию к значению внутри Option.
// Если значение есть (Some), функция выполняется и возвращается новый Some с результатом.
// Если значения нет (None), возвращается None. Это позволяет избежать проверки на null и
// безопасно работать с возможным отсутствием значения.

// 1️⃣ Метод, который принимает Option[Int] и возвращает Option[Int], умноженное на 2
def multiplyTwo(num: Option[Int]): Option[Int] = {
  num.map(_ * 2)
}
multiplyTwo(Some(5)) // должно вернуть Some(10)

// 2️⃣ Метод, который принимает Option[String] и возвращает Option[String], где все буквы в нижнем регистре
def lowerCaseOption(str: Option[String]): Option[String] = {
  str.map(_.toLowerCase)
}
lowerCaseOption(Some("Scala")) // должно вернуть Some("scala")

// 3️⃣ Метод, который принимает Option[List[Int]] и возвращает Option[Int] — сумму элементов списка
def sumListOption(num: Option[List[Int]]): Option[Int] = {
  num.map(_.sum)
}
sumListOption(Some(List(1,2,3))) // должно вернуть Some(6)

// 17 - Try
// Try — это контейнер в Scala для безопасного выполнения кода, который может выбросить исключение.
// Он позволяет обрабатывать ошибки функционально без явного try/catch.
// Результат может быть Success(value) или Failure(exception).

// 1️⃣ Метод, который принимает два числа и безопасно делит первое на второе, возвращает Try[Int]
def safeDivide(a: Int, b: Int): Try[Int] = {
  Try(a / b)
}
safeDivide(10, 2) // должно вернуть Success(5)

// 2️⃣ Метод, который принимает строку и безопасно превращает её в число, возвращает Try[Int]
def parseInt(str: String): Try[Int] = {
  Try(
    str.toInt
  )
}
parseInt("42") // должно вернуть Success(42)

// 3️⃣ Метод, который принимает строку и возвращает Try[Int], но может вызвать ошибку при некорректной строке
def parseInt(str: String): Try[Int] = {
  Try(
    str.toInt
  )
}
parseInt("abc") // должно вернуть Failure(java.lang.NumberFormatException)

// 18 - Either
// Either — это контейнер, который может содержать либо значение типа Left (обычно для ошибки),
// либо значение типа Right (обычно для успешного результата).
// Используется для безопасного возвращения ошибки или результата без выброса исключения.

// 1️⃣ Метод, который принимает число и возвращает Right(число) если оно положительное,
// иначе Left("Отрицательное число")
def checkPositive(num: Int): Either[String, Int] = {
  if (num < 0) Left("Отрицательное число")
  else Right(num)
}
checkPositive(5)   // должно вернуть Right(5)
checkPositive(-3)  // должно вернуть Left("Отрицательное число")

// 2️⃣ Метод, который принимает строку и возвращает Right(число), если строка корректная,
// иначе Left("Ошибка преобразования")
def stringToNumber(str: String): Either[String, Int] = {
  Try(
    str.toInt
  ).toEither.left.map(_ => s"Ошибка преобразования")
}
stringToNumber("42") // должно вернуть Right(42)
stringToNumber("abc")// должно вернуть Left("Ошибка преобразования")

// 3️⃣ Метод, который принимает список чисел и возвращает Right(сумма) если все числа положительные,
// иначе Left("Есть отрицательные числа")
def sumPositiveList(nums: List[Int]): Either[String, Int] = {
  if (nums.exists(_ < 0)) Left("Есть отрицательные числа")
  else Right(nums.sum)
}
sumPositiveList(List(1,2,3))    // должно вернуть Right(6)
sumPositiveList(List(1,-2,3))   // должно вернуть Left("Есть отрицательные числа")

