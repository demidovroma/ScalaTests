// Дана строка, содержащая прописные/строчные буквы алфавита и символы пробела.
// Верните длину последнего слова в строке.
//
// Примечание:
// - Слово определяется как последовательность символов, не содержащее пробела.
// - Если последнее слово отсутствует, вернуть 0.

def solution(s: String): Int = {
  if (s.lastOption.contains(' '))
    0
  else
    s.trim.split("\\s+").last.length
}

println(s"Task 3 = ${solution("Hello World")}")
// Task 3 = 5

println(s"Task 3 = ${solution("abc ")}")



var s = "abc "
// Разделяем строку по пробелам
val words = s.trim.split("\\s+")

// Проверяем, есть ли хотя бы одно слово
if (words.isEmpty) 0
else {
  // Проверяем последний символ исходной строки
  if (s.lastOption.contains(' ')) 0
  else words.last.length
}
