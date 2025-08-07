// По заданной строке найдите длину самой длинной подстроки без повторяющихся символов.

object Task8 {
  def solution(s: String): Int = {
    s.toSet.mkString.length
  }

  println(s"Task 8 = ${solution("abcabcbb")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("bbbbb")}")
  // Task 8 = 1

  println(s"Task 8 = ${solution("pwwkew")}")
  // Task 8 = 3

  println(s"Task 8 = ${solution("")}")
  // Task 8 = 0

}
