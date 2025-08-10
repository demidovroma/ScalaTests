// Даны входная строка и шаблон(паттерн).
// Реализуйте сопоставление строки с регулярным выражением по заданному шаблону с поддержкой символов . и *.
//
// Примечание:
// - Символ . соответствует любому отдельному символу, * - ноль или более предыдущего элемента.
// - Соответствие должно охватывать всю входную строку (не частично).
// - Строка может быть пустой или содержать только строчные буквы a-z.
// - Шаблон(паттерн) может быть пустым или содержать только строчные буквы a-z, а также символы . и *.

object Task9 {
  def solution(s: String, p: String): Boolean = {
    def matchPattern(s: String, p: String): Boolean = {
      // Базовый случай: оба пустые
      if (s.isEmpty && p.isEmpty) true
      // Если шаблон пустой, а строка нет
      else if (p.isEmpty) false
      // Если строка пустая, проверяем шаблон на *
      else if (s.isEmpty) {
        if (p.length >= 2 && p(1) == '*') matchPattern(s, p.substring(2))
        else false
      } else {
        val firstMatch = p(0) == '.' || p(0) == s(0)

        if (p.length >= 2 && p(1) == '*') {
          // Вариант 1: игнорируем * и символ перед ним
          // Вариант 2: используем символ и продолжаем с тем же шаблоном
          matchPattern(s, p.substring(2)) ||
            (firstMatch && matchPattern(s.substring(1), p))
        } else {
          firstMatch && matchPattern(s.substring(1), p.substring(1))
        }
      }
    }

    matchPattern(s, p)
  }

  println(s"Task 9 = ${solution("aa", "a")}")
  // Task 9 = false

  println(s"Task 9 = ${solution("aa", "a*")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("ab", ".*")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("aab", "c*a*b")}")
  // Task 9 = true

  println(s"Task 9 = ${solution("mississippi", "mis*is*p*.")}")
  // Task 9 = false

}
