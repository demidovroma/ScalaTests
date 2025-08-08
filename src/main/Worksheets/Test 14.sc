// Дано не пустая строка и словарь содержащий список не пустых слов.
// Добавьте пробелы в строку, чтобы создать предложение,
// где каждое слово является допустимым словарным словом.
// Верните все такие возможные предложения.
//
// Примечание:
//- Одно и то же слово в словаре может быть многократно использовано в сегментации.
//- Словарь не содержит повторяющихся слов.

def solution(s: String, wordDict: List[String]): List[String] = {



  // Your code
}

println(s"Task 14 = ${solution("catsanddog", List("cat", "cats", "and", "sand", "dog"))}")
// Task 14 = List(
//   "cats and dog",
//   "cat sand dog"
// )

println(s"Task 14 = ${solution("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))}")
// Task 14 = List(
//   "pine apple pen apple",
//   "pineapple pen apple",
//   "pine applepen apple"
// )

println(s"Task 14 = ${solution("catsandog", List("cats", "dog", "sand", "and", "cat"))}")
// Task 14 = List()

println(s"Task 14 = ${solution("abcd", List("a", "abc", "b", "cd"))}")
// Task 14 = List(a b cd)
}
