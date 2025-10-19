// Написать функцию, которая принимает список целых чисел и возвращает список,
// состоящий из всех чисел под четным индексом, которые являются нечетными.

def nums (n: List[Int]): List[Int] = {
  n.zipWithIndex.collect {
    case (i, v) if i % 2 == 0 && v % 2 != 0=> v
  }
}

nums (List(1,2,3,4))

// Написать функцию, принимающую список значений (List[Option[Int]]) и выводящую сумму этих чисел.

def summary (nums: List[Option[Int]]): Int = {
  nums.flatten.sum
}

summary (List(Some(1), Some(2), Some(3), Some(4)))

// Написать функцию, принимающую значение List[List[Int]].
// Для каждого непустого вложенного списка необходимо найти сумму всех элементов,
// больших 100, а для каждого пустого вернуть его индекс.

def sums(listNums: List[List[Int]]): List[Int] = {
  val nums = listNums.zipWithIndex

  for {
    (el, i) <- nums
  } yield if (el.isEmpty) i else el.sum
}

sums (List(List(1,2,3,4), List(1,2,3,4), List()))

// Написать функцию, принимающую 3 списка List[Double] и возвращающую список троек чисел (Double, Double, Double),
// где хотя бы один из элементов из этой тройки > 100.

def getMore(l1: List[Double], l2: List[Double], l3: List[Double]): List[(Double, Double, Double)] = {

  // for {
  //   ls1 <- l1
  //   ls2 <- l2
  //   ls3 <- l3
  //   if ls1 > 100 || ls2 > 100 || ls3 > 100
  // } yield (ls1, ls2, ls3)

  l1.flatMap(ls1 => l2.flatMap(ls2 => l3.collect { case ls3 if(ls1 > 100 || ls2 > 100 || ls3 > 100) => (ls1, ls2, ls3) }))
}

getMore(List(100.2, 1.8, 2.2), List(1.2, 1.8), List(1.2, 1.8, 2.2, 2.2))


// Представим, что мы должны написать функцию для управления библиотекой.
// Функция должна принимать список авторов, а возвращать список вида
// List((Автор1, List[Книга]), (Автор2, List[Книга])).
// Представим, что мы получаем полную коллекцию произведений из базы в виде списка
// List((Автор1, Книга1), (Автор1, Книга2), (Автор1, Книга3), (Автор2, Книга1), ...)

val library = List(
  ("Автор1", "1 Книга автора 1"),
  ("Автор1", "2 Книга автора 1"),
  ("Автор2", "1 Книга автора 2"),
  ("Автор2", "2 Книга автора 2"),
  ("Автор3", "1 Книга автора 3"),
  ("Автор3", "2 Книга автора 3")
)

def getBooks(authors: List[String]): List[(String, List[String])] = {
  val lib = library.groupMap(_._1)(_._2)
  authors.map(a => lib.filter(b => b._1.contains(a))).foldLeft(List.empty[(String, List[String])])
}

getBooks(List("Автор1", "Автор2", "Автор3"))














