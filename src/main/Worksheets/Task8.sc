// По заданной строке найдите длину самой длинной подстроки без повторяющихся символов.

  def solution(s: String): Int = {
    var maxLength = 0
    var start = 0
    var charIndexMap = Map[Char, Int]()

    for (end <- s.indices) {
      val char = s(end)
      if (charIndexMap.contains(char)) {
        start = math.max(start, charIndexMap(char) + 1)
      }
      charIndexMap += (char -> end)
      maxLength = math.max(maxLength, end - start + 1)
    }
    maxLength
  }

  println(s"Task 8 = ${solution("abcabcbb")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("bbbbb")}")
  // Task 8 = 1

  println(s"Task 8 = ${solution("pwwkew")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("")}")
  // Task 8 = 0

  println(s"Task 8 = ${solution("aabbccaa")}")
  // Task 8 = 2
