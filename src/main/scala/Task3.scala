// Дана строка, содержащая прописные/строчные буквы алфавита и символы пробела.
// Верните длину последнего слова в строке.
//
// Примечание:
// - Слово определяется как последовательность символов, не содержащее пробела.
// - Если последнее слово отсутствует, вернуть 0.

object Task3 {
  def solution(s: String): Int = {
    if (s.lastOption.contains(' '))
      0
    else
      s.trim.split("\\s+").last.length

  }

  println(s"Task 3 = ${solution("Hello World")}")
  // Task 3 = 5

  println(s"Task 3 = ${solution("abc ")}")
  // Task 3 = 0
}
