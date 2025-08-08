// Даны два не пустых связных списка, представляющих два неотрицательных целых числа.
// Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
// Суммируйте два числа и верните их в виде связанного списка.
// Примечание:
//- Два числа не содержат нуля в начале, кроме самого числа 0.



// Дана строка содержащая только цифры.
// Восстановите ее, вернув все возможные допустимые комбинации IP-адресов.
// Примечание:
//- Действительный IP-адрес состоит ровно из четырех целых чисел, каждое целое число находится в диапазоне от 0 до 255,
// разделенных одиночными точками и не может иметь нулей в начале кроме самого числа 0.
// Например, «0.3.14.221» и «192.168.0.1» -
// допустимые IP-адреса, а «0.033.255.247», «192.168.0.299» и «192.168@0.1» - недопустимые IP-адреса.
//- 0 <= s.length <= 3000
//- Строка состоит только из цифр.





//**************************************************************************************
  def restoreIpAddresses(s: String): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()
    val n = s.length

    def isValidPart(part: String): Boolean = {
      if (part.isEmpty || (part.length > 1 && part.startsWith("0"))) {
        false
      } else {
        val num = part.toInt
        num >= 0 && num <= 255
      }
    }

    def backtrack(index: Int, parts: List[String]): Unit = {
      if (parts.length == 4) {
        if (index == n) {
          result.append(parts.mkString("."))
        }
        return
      }

      for (i <- 1 to 3) {
        if (index + i <= n) {
          val part = s.substring(index, index + i)
          if (isValidPart(part)) {
            backtrack(index + i, parts :+ part)
          }
        }
      }
    }

    backtrack(0, List())
    result.toList
  }

    println(s"Task 13 = ${restoreIpAddresses("010010")}")

    val ipString = "25525511135"
    val restoredAddresses = restoreIpAddresses(ipString)
    println(s"Restored IP addresses for $ipString: $restoredAddresses")

    val ipString2 = "0000"
    val restoredAddresses2 = restoreIpAddresses(ipString2)
    println(s"Restored IP addresses for $ipString2: $restoredAddresses2")

    val ipString3 = "101023"
    val restoredAddresses3 = restoreIpAddresses(ipString3)
    println(s"Restored IP addresses for $ipString3: $restoredAddresses3")

//**************************************************************************************






















def solution(s: String): List[String] = {
  // Определяем список для хранения результатов
  var result = List[String]()

  // Вложенная функция для генерации всех возможных IP-адресов
  def backtrack(start: Int, parts: List[String]): Unit = {
    // Если достигли конца строки и у нас 4 сегмента, добавляем результат
    if (start == s.length && parts.length == 4) {
      result = result :+ parts.mkString(".")
      return
    }
    // Если у нас больше 4 сегментов или мы исчерпали все символы, завершаем
    if (parts.length >= 4) {
      return
    }

    parts

    // Проверяем все возможные длины сегментов (1-3 символа)
    for (len <- 1 to 3) {
      if (start + len <= s.length) {
        // Извлекаем сегмент
        val segment = s.substring(start, start + len)

        // Проверяем, чтобы сегмент был корректным
        // Нельзя, чтобы сегмент начинался с '0', если это не единственный символ
        if ((segment.length > 1 && !segment.startsWith("0")) || segment.toInt < 255) {
          // Пропускаем некорректные сегменты
          //continue
          backtrack(start + len, parts :+ segment)
        }

          // Рекурсивно продолжаем с новым сегментом


      }
    }
  }

  // Начинаем с 0 символов и пустого списка сегментов
  backtrack(0, List())
  result

}
println(s"Task 13 = ${solution("010010")}")






var s = "010010"

val ipPattern = """(?:(25[0-5]|2[0-4][0-9]|[1-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[1-9][0-9]?)""".r

// Генерируем все возможные IP-адреса из строк
val possibleIps = for {
  a <- 1 to 3
  b <- 1 to 3
  c <- 1 to 3
  d <- 1 to 3
  if a + b + c + d == s.length
  ip = s.substring(0, a) + "." + s.substring(a, a + b) + "." + s.substring(a + b, a + b + c) + "." + s.substring(a + b + c)
  if ipPattern.findFirstIn(ip).isDefined
} yield ip

possibleIps.toList




def solution(s: String): List[String] = {

  //s.strip().matches("""^((25[0-5]|2[0-4]\d|1?\d\d?)\.){3}$""")

  val ipPattern = """(?:(25[0-5]|2[0-4][0-9]|1[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)""".r

  // Генерируем все возможные IP-адреса из строк
  val possibleIps = for {
    a <- 1 to 3
    b <- 1 to 3
    c <- 1 to 3
    d <- 1 to 3
    if a + b + c + d == s.length
    ip = s.substring(0, a) + "." + s.substring(a, a + b) + "." + s.substring(a + b, a + b + c) + "." + s.substring(a + b + c)
    if ipPattern.findFirstIn(ip).isDefined
  } yield ip

  possibleIps.toList
}

println(s"Task 13 = ${solution("25525511135")}")
// Task 13 = List("255.255.11.135", "255.255.111.35")

println(s"Task 13 = ${solution("0000")}")
// Task 13 = List("0.0.0.0")

println(s"Task 13 = ${solution("1111")}")
// Task 13 = List("1.1.1.1")

println(s"Task 13 = ${solution("010010")}")
// Task 13 = List("0.10.0.10", "0.100.1.0")

println(s"Task 13 = ${solution("101023")}")
// Task 13 = List("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")

println(s"Task 13 = ${solution("2552551113500001111010010101023")}")
// Task 13 = List()













// Дана n x n 2D матрица (двумерный массив) представляющая изображение.
// Поверните изображение на 90 градусов (по часовой стрелке).
//
//Примечание:
//- Вы должны повернуть изображение на месте, что означает, что вы должны изменить входную 2D матрицу напрямую.
// НЕ выделяйте другую 2D матрицу.

val matrix = Array(
  Array(1, 2, 3),
  Array(4, 5, 6),
  Array(7, 8, 9)
)

val n = matrix.length

// Транспонируем матрицу
for (i <- 0 until n) {
  for (j <- i until n) {
    val temp = matrix(i)(j)
    matrix(i)(j) = matrix(j)(i)
    matrix(j)(i) = temp
  }
}

matrix

// Отражаем каждую строку
for (i <- 0 until n) {
  for (j <- 0 until n / 2) {
    val temp = matrix(i)(j)
    matrix(i)(j) = matrix(i)(n - 1 - j)
    matrix(i)(n - 1 - j) = temp
  }
}

matrix







def solution(matrix: Array[Array[Int]]): Array[Array[Int]] = {

//  val n = matrix.length

//  // Транспонируем матрицу
//  for (i <- 0 until n) {
//    for (j <- i until n) {
//      val temp = matrix(i)(j)
//      matrix(i)(j) = matrix(j)(i)
//      matrix(j)(i) = temp
//    }
//  }
//
//  // Отражаем каждую строку
//  for (i <- 0 until n) {
//    for (j <- 0 until n / 2) {
//      val temp = matrix(i)(j)
//      matrix(i)(j) = matrix(i)(n - 1 - j)
//      matrix(i)(n - 1 - j) = temp
//    }
//  }

  matrix
}

val matrix1 = Array(
  Array(1, 2, 3),
  Array(4, 5, 6),
  Array(7, 8, 9)
)
println(s"Task 10 = ${solution(matrix1)}")


val matrix1 = Array(
  Array(1, 2, 3),
  Array(4, 5, 6),
  Array(7, 8, 9)
)

val matrix2 = Array(
  Array(5, 1, 9, 11),
  Array(2, 4, 8, 10),
  Array(13, 3, 6, 7),
  Array(15, 14, 12, 16),
)

println(s"Task 10 = ${solution(matrix1)}")
//Task 10 = Array(
//  Array(7, 4, 1),
//  Array(8, 5, 2),
//  Array(9, 6, 3)
//)

println(s"Task 10 = ${solution(matrix2)}")
//Task 10 = Array(
//  Array(15, 13, 2, 5),
//  Array(14, 3, 4, 1),
//  Array(12, 6, 8, 9),
//  Array(16, 7, 10, 11)
//)











