// Дана строка содержащая только цифры.
// Восстановите ее, вернув все возможные допустимые комбинации IP-адресов.
//
// Примечание:
// - Действительный IP-адрес состоит ровно из четырех целых чисел,
// каждое целое число находится в диапазоне от 0 до 255,
// разделенных одиночными точками и не может иметь нулей в начале кроме самого числа 0.
// Например, «0.3.14.221» и «192.168.0.1» - допустимые IP-адреса,
// а «0.033.255.247», «192.168.0.299» и «192.168@0.1» - недопустимые IP-адреса.
// - 0 <= s.length <= 3000
// - Строка состоит только из цифр.

object Task13 {
  def solution(s: String): List[String] = {
    def isValid(part: String): Boolean = {
      if (part.length > 1 && part.startsWith("0")) false
      else part.toInt <= 255
    }

    def findIPs(s: String, start: Int, partsLeft: Int, current: String, result: List[String]): List[String] = {
      if (partsLeft == 0) {
        if (start == s.length)
          current :: result
        else
          result
      } else {
        val minLength = math.max(1, (s.length - start - 3 * (partsLeft - 1)))
        val maxLength = math.min(3, s.length - start)

        // Добавляем проверку на минимальную/максимальную длину
        if (minLength > maxLength) result
        else {
          (minLength to maxLength).foldLeft(result) { (acc, length) =>
            val part = s.substring(start, start + length)
            if (isValid(part)) {
              val newCurrent =
                if (current.isEmpty) part
                else s"$current.$part"
              findIPs(s, start + length, partsLeft - 1, newCurrent, acc)
            } else acc
          }
        }
      }
    }

    findIPs(s, 0, 4, "", Nil)
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
}
