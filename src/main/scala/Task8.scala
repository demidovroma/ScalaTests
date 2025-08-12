// По заданной строке найдите длину самой длинной подстроки без повторяющихся символов.

import scala.annotation.tailrec

object Task8 {
  def solution(s: String): Int = {
    @tailrec
    def loop(start: Int, end: Int, charMap: Map[Char, Int], maxLength: Int): Int = {
      if (end == s.length) {
        maxLength
      } else {
        val currentChar = s(end)
        val newStart = if (charMap.exists { case (char, index) => char == currentChar && index >= start })
          charMap(currentChar) + 1
        else
          start

        val newMap = charMap + (currentChar -> end)
        val newMaxLength = math.max(maxLength, end - newStart + 1)

        loop(newStart, end + 1, newMap, newMaxLength)
      }
    }

    loop(0, 0, Map.empty, 0)
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
  // Task 8 = 0

}
