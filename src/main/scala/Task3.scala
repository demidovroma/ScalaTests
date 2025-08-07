object Task3 {
  def solution(s: String): Int = {
    s.split(" ").last.length
  }

  println(s"Task 3 = ${solution("Hello World")}")
  // Task 3 = 5
}
