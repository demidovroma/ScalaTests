// Дано не пустая строка и словарь содержащий список не пустых слов.
// Добавьте пробелы в строку, чтобы создать предложение, где каждое слово является допустимым словарным словом.
// Верните все такие возможные предложения.
//
// Примечание:
// - Одно и то же слово в словаре может быть многократно использовано в сегментации.
// - Словарь не содержит повторяющихся слов.

  def solution(s: String, wordDict: List[String]): List[String] = {
    // Преобразуем словарь в множество для быстрого поиска
    val wordSet = wordDict.toSet
    // Используем память для хранения результатов
    val memo = scala.collection.mutable.Map[String, List[String]]()

    // Вложенная функция для выполнения рекурсивного поиска
    def wordBreak(start: Int): List[String] = {
      // Если уже обрабатывали данную подстроку, возвращаем закэшированные результаты
      if (memo.contains(s.substring(start))) return memo(s.substring(start))

      // Список для хранения всех возможных предложений
      var result = List[String]()

      // Проходимся по подстроке
      for (end <- start + 1 to s.length) {
        val word = s.substring(start, end) // Текущая подстрока
        // Если слово в словаре
        if (wordSet.contains(word)) {
          // Если исчерпали строку, добавляем текущее слово к результату
          if (end == s.length) {
            result = result :+ word
          } else {
            // Рекурсивный вызов для оставшейся подстроки
            val restOfTheSentence = wordBreak(end)
            for (sentence <- restOfTheSentence) {
              result = result :+ (word + " " + sentence)
            }
          }
        }
      }

      // Сохраняем результаты в кэш
      memo(s.substring(start)) = result
      result
    }

    // Запускаем рекурсивный поиск с начальным индексом 0
    wordBreak(0)
  }

  println(s"Task 14 = ${solution("catsanddog", List("cat", "cats", "and", "sand", "dog"))}")
  // Task 14 = List("cats and dog", "cat sand dog")

  println(s"Task 14 = ${solution("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))}")
  // Task 14 = List("pine apple pen apple", "pineapple pen apple", "pine applepen apple")

  println(s"Task 14 = ${solution("catsandog", List("cats", "dog", "sand", "and", "cat"))}")
  // Task 14 = List()

  println(s"Task 14 = ${solution("abcd", List("a", "abc", "b", "cd"))}")
  // Task 14 = List("a b cd")

