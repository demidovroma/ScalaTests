import scala.annotation.tailrec

// Task 2: Забываем о return, его не используем никогда.
// Последнее выражение в блоке всегда означает выводимое значение.
// Плюс ко всему, крайне не оптимальное решение.
// Если число будет больше, чем максимальная вместимость списка,
// то она вообще не сработает.
// Нужно переделать в хвостовую рекурсию,
// при этом накапливая в целом числе цифры исходного числа в обратном порядке на каждом шаге рекурсии. -



val x = 11

//x.toString.map(_.asDigit).toList


//@annotation.tailrec // Аннотация для явного указания на хвостовую рекурсию

@tailrec
def loop(n: Int, accumulator: Int): Int = {
  if (n == 0)
    accumulator/10
  else
    loop(n / 10, (accumulator + n % 10) * 10)
}

if(x > 0)
loop(x, 0) == x
else
  false



def solution(x: Int): Boolean = {
  @tailrec
  def loop(n: Int, accumulator: Int): Int = {
    if (n == 0)
      accumulator/10
    else
      loop(n / 10, (accumulator + n % 10) * 10)
  }

  if(x > 0)
    loop(x, 0) == x
  else
    false
}

println(s"Task 2 = ${solution(121)}")
// Task 2 = true

println(s"Task 2 = ${solution(-121)}")
// Task 2 = false

println(s"Task 2 = ${solution(10)}")
// Task 2 = false

println(s"Task 2 = ${solution(-101)}")
// Task 2 = false
