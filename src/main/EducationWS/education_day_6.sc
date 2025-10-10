// List Sum Method
// 1. Найти сумму всех элементов списка.
def sumAll(nums: List[Int]): Int = {
  nums.sum
}
sumAll(List(1,2,3)) // Должно вернуть 6

// 2. Найти сумму только чётных чисел.
def sumEven(nums: List[Int]): Int = {
  nums.filter(_ % 2 == 0).sum
}
sumEven(List(1,2,3,4,5,6)) // Должно вернуть 12

// 3. Найти сумму длин всех строк в списке.
def sumLengths(words: List[String]): Int = {
  words.map(_.length).sum
}
sumLengths(List("a", "bb", "ccc")) // Должно вернуть 6

// 4. Сумма чисел в списке списков.
def sumNested(lists: List[List[Int]]): Int = {
  lists.flatten.sum
}
sumNested(List(List(1,2), List(3,4))) // Должно вернуть 10

// 5. Найти сумму элементов с индексами больше 2.
def sumAfterIndex(nums: List[Int]): Int = {
  nums.drop(3).sum
}
sumAfterIndex(List(1,2,3,4,5)) // Должно вернуть 9



// List Filter Method
// 1. Оставить только чётные числа.
def filterEven(nums: List[Int]): List[Int] = {
  nums.filter(_ % 2 == 0)
}
filterEven(List(1,2,3,4)) // List(2,4)

// 2. Убрать отрицательные числа.
def removeNegatives(nums: List[Int]): List[Int] = {
  nums.filter(_ > 0)
}
removeNegatives(List(-1, 0, 5, -3)) // List(0,5)

// 3. Оставить только строки длиннее 3 символов.
def longWords(words: List[String]): List[String] = {
  words.filter(_.length > 3)
}
longWords(List("hi", "scala", "map")) // List("scala")

// 4. Отфильтровать числа больше среднего.
def greaterThanAvg(nums: List[Int]): List[Int] = {
  val avg = nums.sum.toDouble / nums.length
  nums.filter(_ > avg)
}
greaterThanAvg(List(1,5,7,3,9)) // List(7,9)

// 5. Оставить только уникальные чётные числа.
def uniqueEven(nums: List[Int]): List[Int] = {
  nums.toSet.toList.filter(_ % 2 == 0)
}
uniqueEven(List(2,2,3,4,4,6)) // List(2,4,6)



// Map for List
// 1. Удвоить все элементы списка.
def doubleList(nums: List[Int]): List[Int] = {
  nums.map(_ * 2)
}
doubleList(List(1,2,3)) // List(2,4,6)

// 2. Добавить суффикс "_ok" ко всем строкам.
def addOk(words: List[String]): List[String] = {
  words.map(_ + "_ok")
}
addOk(List("a","b")) // List("a_ok","b_ok")

// 3. Получить длины всех строк.
def lengths(words: List[String]): List[Int] = {
  words.map(_.length)
}
lengths(List("ab", "c")) // List(2,1)

// 4. Возвести все числа в квадрат.
def squares(nums: List[Int]): List[Int] = {
  nums.map(n => n * n)
}
squares(List(2,3,4)) // List(4,9,16)

// 5. Преобразовать все Option[Int] в строки.
def optionsToStrings(opts: List[Option[Int]]): List[String] = {
  opts.flatMap(s => List(s.toString))
}
optionsToStrings(List(Some(1), None, Some(3))) // List("1","None","3")



// List Flatten
// 1. Объединить список списков в один.
def flattenLists(lists: List[List[Int]]): List[Int] = {
  lists.flatten
}
flattenLists(List(List(1,2), List(3,4))) // List(1,2,3,4)

// 2. Убрать все None из списка Option.
def flattenOptions(opts: List[Option[Int]]): List[Int] = {
  opts.flatten
}
flattenOptions(List(Some(1), None, Some(3))) // List(1,3)

// 3. Превратить список строк списков в единый список символов.
def flattenChars(words: List[String]): List[Char] = {
  words.flatten
}
flattenChars(List("ab","cd")) // List('a','b','c','d')

// 4. Превратить список Option[List[Int]] в плоский список Int.
def flattenOptionLists(opts: List[Option[List[Int]]]): List[Int] = {
  opts.flatten.flatten
}
flattenOptionLists(List(Some(List(1,2)), None, Some(List(3)))) // List(1,2,3)

// 5. Объединить список Future[List[Int]] в один Future[List[Int]].
def flattenFutureLists(): Unit = {

}



// flatMap
// 1. Удвоить и расплющить список чисел.
def flatDouble(nums: List[Int]): List[Int] = {
  nums.flatMap(n => List(n, n * 2))
}
flatDouble(List(1,2)) // List(1, 2, 2, 4)

// 2. Превратить список слов в список символов.
def flatChars(words: List[String]): List[Char] = {
  words.flatMap(_.toList)
}
flatChars(List("hi","ok")) // List('h','i','o','k')

// 3. Преобразовать список Option[Int] в список Int.
def flatOptions(opts: List[Option[Int]]): List[Int] = {
  opts.flatMap(n => List(n).flatten)
}
flatOptions(List(Some(1), None, Some(2))) // List(1,2)

// 4. Скомбинировать пары (i, j) для двух списков.
def pairs(a: List[Int], b: List[Int]): List[(Int, Int)] = {
  a.flatMap(i => b.map(j => (i, j)))
}
pairs(List(1,2), List(3,4)) // List((1,3),(1,4),(2,3),(2,4))

// 5. Применить flatMap для списка списков и увеличить элементы на 1.
def flatAddOne(lists: List[List[Int]]): List[Int] = {
  lists.flatMap(n => n.map(_ + 1))
}
flatAddOne(List(List(1,2), List(3))) // List(2,3,4)



// foldLeft
// 1. Найти сумму элементов.
def foldSum(nums: List[Int]): Int = {
  nums.foldLeft(0)(_ + _)
}
foldSum(List(1,2,3)) // 6

// 2. Конкатенация строк.
def foldConcat(words: List[String]): String = {
  words.foldLeft("")(_ + _)
}
foldConcat(List("a","b","c")) // "abc"

// 3. Найти максимум.
def foldMax(nums: List[Int]): Int = {
  nums.foldLeft(0)((acc, n) => if (n > acc) n else acc)
}
foldMax(List(1,7,3)) // 7

// 4. Посчитать количество элементов больше 3.
def foldCount(nums: List[Int]): Int = {
  nums.foldLeft(0)((acc, n) => if (n > 3) acc + 1 else acc)
}
foldCount(List(1,4,5)) // 2

// 5. Посчитать сумму квадратов.
def foldSquareSum(nums: List[Int]): Int = {
  nums.foldLeft(0)((acc, n) => acc + n * n)
}
foldSquareSum(List(2,3)) // 13



// for-comprehension
// 1. Сгенерировать пары чисел (i, j).
def genPairs(a: List[Int], b: List[Int]): List[(Int, Int)] = {
  for {
    a1 <- a
    b1 <- b
  } yield (a1, b1)
}
genPairs(List(1,2), List(3,4)) // List((1,3),(1,4),(2,3),(2,4))

// 2. Отфильтровать и вернуть чётные числа.
def evenFor(nums: List[Int]): List[Int] = {
  for {
    n <- nums
    if(n % 2 ==0)
  } yield n
}
evenFor(List(1,2,3,4)) // List(2,4)

// 3. Комбинировать Option и List.
def optionList(opt: Option[Int], nums: List[Int]): List[Int] = {
  for {
    a1 <- opt.toList
    b1 <- nums
  } yield a1 + b1
}
optionList(Some(2), List(1,2,3)) // List(3,4,5)

// 4. Комбинировать два Option[Int].
def combineOption(a: Option[Int], b: Option[Int]): Option[Int] = {
  for {
    a1 <- a
    b1 <- b
  } yield a1 + b1
}
combineOption(Some(2), Some(3)) // Some(5)

// 5. Использовать for для фильтрации и трансформации.
def filterAndMap(nums: List[Int]): List[Int] = {
  for {
    i <- nums
    if (i % 2 == 0)
  } yield i * 2
}
filterAndMap(List(1,2,3,4)) // List(4,8)



// exists
// 1. Проверить, есть ли чётное число.
def hasEven(nums: List[Int]): Boolean = {
  nums.exists(_ % 2 == 0)
}
hasEven(List(1,3,5,6)) // true

// 2. Проверить, содержит ли список строку "scala".
def containsScala(words: List[String]): Boolean = {
  words.exists(_ == "scala")
}
containsScala(List("java","scala")) // true

// 3. Проверить, есть ли число > 100.
def hasLarge(nums: List[Int]): Boolean = {
  nums.exists(_ > 100)
}
hasLarge(List(10,50,120)) // true

// 4. Проверить, есть ли хотя бы один None.
def hasNone(opts: List[Option[Int]]): Boolean = {
  opts.exists(_.isEmpty)
}
hasNone(List(Some(1), None, Some(3))) // true

// 5. Проверить, есть ли отрицательные значения.
def hasNegative(nums: List[Int]): Boolean = {
  nums.exists(_ < 0)
}
hasNegative(List(1,2,-3)) // true



// forAll
// 1. Все ли числа положительные.
def allPositive(nums: List[Int]): Boolean = {
  nums.forall(_ > 0)
}
allPositive(List(1,2,3)) // true

// 2. Все ли строки длиннее 2.
def allLong(words: List[String]): Boolean = {
  words.forall(_.length > 2)
}
allLong(List("hey","yo")) // false

// 3. Все ли Option заполнены.
def allDefined(opts: List[Option[Int]]): Boolean = {
  opts.forall(_.isDefined)
}
allDefined(List(Some(1), Some(2))) // true

// 4. Все ли числа чётные.
def allEven(nums: List[Int]): Boolean = {
  nums.forall(_ % 2 == 0)
}
allEven(List(2,4,6)) // true

// 5. Все ли элементы списка непустые строки.
def allNonEmpty(words: List[String]): Boolean = {
  words.forall(_.nonEmpty)
}
allNonEmpty(List("a","")) // false



// headOption
// 1. Вернуть первый элемент списка.
def firstOpt(nums: List[Int]): Option[Int] = {
  nums.headOption
}
firstOpt(List(1,2,3)) // Some(1)

// 2. Вернуть первый элемент > 5.
def firstGreaterThan5(nums: List[Int]): Option[Int] = {
  nums.filter(_ > 5).headOption
}
firstGreaterThan5(List(1,3,7,8)) // Some(7)

// 3. Вернуть первый непустой Option.
def firstDefined(opts: List[Option[Int]]): Option[Int] = {
  opts.filter(_.isDefined).headOption.flatten
}
firstDefined(List(None, Some(3), Some(4))) // Some(3)

// 4. Вернуть первый элемент строки, если она не пуста.
def firstChar(word: String): Option[Char] = {
  word.headOption
}
firstChar("Scala") // Some('S')
firstChar("")

// 5. Вернуть None, если список пуст.
def safeHead(nums: List[Int]): Option[Int] = {
  nums.headOption
}
safeHead(List()) // None



// Option
// 1. Вернуть Option[Int], если число положительное.
def positiveOpt(n: Int): Option[Int] = {
  if (n > 0) Some(n) else None
}
positiveOpt(-1) // None

// 2. Вернуть Option длины строки, если строка непуста.
def lengthOpt(s: String): Option[Int] = {
  if (s.nonEmpty) Some(s.length) else None
}
lengthOpt("") // None

// 3. Деление с проверкой делителя.
def safeDiv(a: Int, b: Int): Option[Int] = {
  if (b != 0 || b > 0) Some(a / b) else None
}
safeDiv(10,0) // None
safeDiv(10,2)

// 4. Option суммы двух Option[Int].
def sumOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
  for {
    x <- a
    y <- b
  } yield x + y
}
sumOptions(Some(2), Some(3)) // Some(5)

// 5. Вернуть Option первого элемента > 10.
def firstBig(nums: List[Int]): Option[Int] = {
  nums.find(_ > 10)
}
firstBig(List(3,15,8)) // Some(15)



// Option map
// 1. Удвоить значение Option[Int].
def doubleOpt(opt: Option[Int]): Option[Int] = {
  opt.map(_ * 2)
}
doubleOpt(Some(3)) // Some(6)

// 2. Преобразовать Option[String] в длину строки.
def lengthFromOpt(opt: Option[String]): Option[Int] = {
  opt.map(_.length)
}
lengthFromOpt(Some("scala")) // Some(5)

// 3. Добавить 10 к Option[Int].
def addTen(opt: Option[Int]): Option[Int] = {
  opt.map(_ + 10)
}
addTen(Some(5)) // Some(15)

// 4. Умножить Option[Int] на другой Option[Int].
def multOpt(a: Option[Int], b: Option[Int]): Option[Int] = {
  a.flatMap(x => b.map(y => x * y))
}
multOpt(Some(2), Some(3)) // Some(6)

// 5. Преобразовать Option[List[Int]] в сумму элементов.
def sumListOpt(opt: Option[List[Int]]): Option[Int] = {
  opt.map(_.sum)
}
sumListOpt(Some(List(1,2,3))) // Some(6)



// pattern matching OR
// 1. Проверить, является ли символ 'a' или 'b'.
def isAorB(ch: Char): Boolean = ch match {
  case 'a' | 'b' => true
  case _ => false
}
isAorB('a') // true

// 2. Вернуть строку "small" если 1 или 2, иначе "big".
def describeNum(n: Int): String = n match {
  case 1 | 2 => "small"
  case _ => "big"
}
describeNum(2) // "small"

// 3. Проверить день недели "Sat" или "Sun".
def isWeekend(day: String): Boolean = day match {
  case "Sat" | "Sun" => true
}
isWeekend("Sun") // true

// 4. Вернуть true если число 0 или отрицательное.
def isZeroOrNegative(n: Int): Boolean = n match {
  case 0 | _ if ( n < 0 ) => true
}
isZeroOrNegative(-5) // true

// 5. Проверить Option: None или Some(0).
def isEmptyOrZero(opt: Option[Int]): Boolean = opt match {
  case None | Some(_) => true
}
isEmptyOrZero(Some(0)) // true



// Option pattern matching
// 1. Вернуть строку "empty" или "has value".
def describeOpt(opt: Option[Int]): String = opt match {
  case Some(_) => "has value"
  case None => "empty"
}
describeOpt(Some(1)) // "has value"

// 2. Вернуть значение или 0.
def getOrZero(opt: Option[Int]): Int = opt match {
  case Some(n) => n
  case None => 0
}
getOrZero(None) // 0

// 3. Вернуть длину строки из Option[String].
def optLength(opt: Option[String]): Int = opt match {
  case Some(s) => s.length
  case None => 0
}
optLength(Some("hi")) // 2

// 4. Проверить, есть ли значение больше 10.
def bigOpt(opt: Option[Int]): Boolean = opt match {
  case Some(n) if ( n > 10 ) => true
  case Some(_) => false
  case None => false
}
bigOpt(Some(11)) // true

// 5. Вернуть Option[Int] увеличенное на 1.
def incOpt(opt: Option[Int]): Option[Int] = opt match {
  case Some(value) => Some(value + 1)
  case None => Some(0)
}
incOpt(Some(5)) // Some(6)



// List pattern matching
// 1. Вернуть первый элемент.
def firstElem(nums: List[Int]): Int = nums match {
  case head :: tail => head
  case Nil => 0
}
firstElem(List(1,2,3)) // 1

// 2. Вернуть длину 0, если список пуст.
def listLength(nums: List[Int]): Int = nums match {
  case Nil => 0
  case n => n.length
}
listLength(List()) // 0

// 3. Вернуть сумму первого и второго элементов.
def sumTwo(nums: List[Int]): Int = nums match {
  case a :: b :: c => a + b
  case _           => 0
}
sumTwo(List(5,10,3)) // 15

// 4. Вернуть строку "empty", "one", "many".
def describeList(nums: List[Int]): String = nums match {
  case Nil        => "empty"
  case _ :: Nil   => "one"
  case _ :: _     => "many"
}
describeList(List(1,2,3)) // "many"

// 5. Вернуть хвост списка.
def listTail(nums: List[Int]): List[Int] = nums match {
  case head :: tail => tail
  case Nil => List()
}
listTail(List(1,2,3)) // List(2,3)
