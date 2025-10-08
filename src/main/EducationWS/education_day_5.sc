import scala.annotation.tailrec
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt

// День 5
// 24 - Tuple
// Tuple — это неизменяемая структура данных в Scala, которая позволяет хранить несколько значений
// разных типов вместе как единое целое. В отличие от списка, где все элементы одного типа,
// кортеж может содержать элементы разных типов. Доступ к элементам осуществляется через . _1, . _2 и т.д.
// (в зависимости от позиции). Размер кортежа фиксирован при его создании.

// 1️⃣ Метод, который принимает Tuple2[Int, Int] и возвращает их сумму
def sumTuple(nums: Tuple2[Int, Int]): Int = {
  nums._1 + nums._2
}
sumTuple((3, 7)) // должно вернуть 10

// 2️⃣ Метод, который принимает Tuple2[String, Int] и возвращает строку вида "Name: Age"
def formatPerson(person: Tuple2[String, Int]): String = {
  val (name, age) = person
  s"$name: $age"
}
formatPerson(("Roma", 38)) // должно вернуть "Roma: 38"

// 3️⃣ Метод, который принимает Tuple3[Int, Int, Int] и возвращает их среднее арифметическое
def averageTuple(nums: Tuple3[Int, Int, Int]): Int = nums match {
  case (a, b, c) => (a + b + c) / 3
}
averageTuple((3, 6, 9)) // должно вернуть 6

// 25 - Set
// Set в Scala — это коллекция, которая хранит только уникальные элементы, без повторов.
// Порядок элементов в обычном Set не гарантируется. Если нужен упорядоченный набор,
// можно использовать SortedSet или LinkedHashSet.
// Основные операции с Set: добавление элементов, удаление, проверка принадлежности,
// пересечение, объединение и разность множеств.

// 1️⃣ Метод, который принимает Set[Int] и возвращает сумму всех элементов
def sumSet(nums: Set[Int]): Int = {
  nums.sum
}
sumSet(Set(1, 2, 3, 4)) // должно вернуть 10

// 2️⃣ Метод, который принимает Set[String] и возвращает количество элементов в нём
def countSet(str: Set[String]): Int = {
  str.size
}
countSet(Set("apple", "banana", "pear")) // должно вернуть 3

// 3️⃣ Метод, который принимает два Set[Int] и возвращает их объединение
def unionSets(nums1: Set[Int], nums2: Set[Int]): Set[Int] = {
  nums1.union(nums2)
}
unionSets(Set(1, 2), Set(2, 3)) // должно вернуть Set(1, 2, 3)

// 26 - Comparators
// Comparator — это способ определить порядок элементов для сортировки.
// В Scala можно использовать функции Ordering или передавать анонимную функцию
// в sortBy/sortWith для указания собственного порядка.

// 1️⃣ Метод, который сортирует список чисел по возрастанию
def sortAsc(nums: List[Int]): List[Int] = {
  nums.sorted
}
sortAsc(List(5, 2, 9, 1)) // должно вернуть List(1, 2, 5, 9)

// 2️⃣ Метод, который сортирует список строк в алфавитном порядке
def sortAlphabet(str: List[String]): List[String] = {
  str.sorted
}
sortAlphabet(List("banana", "apple", "cherry")) // должно вернуть List("apple", "banana", "cherry")

// 3️⃣ Метод, который сортирует список кортежей (name, score) по убыванию score
def sortByScore(str: List[(String, Int)]): List[(String, Int)] = {
  str.sortBy(-_._2)
}
sortByScore(List(("Alice", 50), ("Bob", 75), ("Charlie", 60))) // должно вернуть List(("Bob", 75), ("Charlie", 60), ("Alice", 50))

// 27  - Recursion
// Рекурсия — это способ организации вычислений, при котором метод вызывает сам себя для решения подзадачи,
// пока не достигнет базового случая. В Scala рекурсия часто используется для работы со списками
// и других структур данных без явных циклов. Важно всегда определять условие выхода,
// иначе произойдет бесконечный вызов.

// 1️⃣ Метод, который рекурсивно вычисляет n-е число Фибоначчи
def fibonacci(n: Int): Int = {
  @tailrec
  def loop(i: Int, prev: Int, acc: Int): Int = {
    if (i >= n) acc
    else loop(i + 1, acc, prev + acc)
  }

  if (n == 0) 0
  else loop(1, 0, 1)
}
fibonacci(5) // должно вернуть 5
fibonacci(10) // 55

// 2️⃣ Метод, который рекурсивно переворачивает список
def reverseList(n: List[Int]): List[Int] = {
  @tailrec
  def loop(remaining: List[Int], acc: List[Int]): List[Int] = remaining match {
    case Nil          => acc
    case h :: t       => loop(t, h :: acc)
  }

  loop(n, Nil)
}
reverseList(List(1, 2, 3)) // должно вернуть List(3, 2, 1)

// 3️⃣ Метод, который рекурсивно проверяет, есть ли элемент в списке
def containsElement(n: List[Int], target: Int): Boolean = {
  @tailrec
  def loop(lst: List[Int]): Boolean = lst match {
    case Nil => false
    case x :: xs =>
      if (x == target) true
      else loop(xs)
  }

  loop(n)
}
containsElement(List(1, 2, 3), 2) // должно вернуть true

// 1️⃣ Метод, который рекурсивно считает сумму элементов списка
def sumListRec(nums: List[Int]): Int = {
  @tailrec
  def loop(n: List[Int], acc: Int): Int = n match {
    case Nil => acc
    case i :: is => loop(is, acc+i)
  }

  loop(nums, 0)
}
sumListRec(List(1,2,3,4)) // должно вернуть 10

// 2️⃣ Метод, который рекурсивно находит максимальный элемент в списке
def maxElement(nums: List[Int]): Int = {
  @tailrec
  def loop(n: List[Int], acc: Int): Int = n match {
    case Nil => acc
    case i :: is => loop(is, if (i > acc) i else acc)
  }

  loop(nums, nums.headOption.getOrElse(0))
}
maxElement(List(3,7,2,5)) // должно вернуть 7

// 3️⃣ Метод, который рекурсивно подсчитывает количество чётных чисел в списке
def countEven(nums: List[Int]): Int = {
  @tailrec
  def loop(n: List[Int], acc: Int): Int = n match {
    case Nil => acc
    case i :: is => loop(is, if (i % 2 == 0) acc +1 else acc)
  }

  loop(nums, 0)
}
countEven(List(1,2,3,4,5,6)) // должно вернуть 3

// 28 - pattern matching
// Pattern Matching в Scala — это мощный инструмент для работы с разными вариантами данных.
// Он позволяет проверять значения по шаблону (pattern) и выполнять действия в зависимости от совпадения.
// Часто используется с коллекциями, Option, case class и sealed trait.
// По сути — это расширенный switch, но более гибкий и выразительный.
//
// С помощью pattern matching можно:
// разбирать списки (head :: tail),
// работать с Option (Some или None),
// сопоставлять case class по их структуре,
// комбинировать условия с if-guards.


// 1️⃣ Метод, который принимает Option[String] и возвращает длину строки, если значение есть, иначе 0
def stringLength(str: Option[String]): Int = str match {
  case Some(value) => value.length
  case None => 0
}
stringLength(Some("scala")) // должно вернуть 5

// 2️⃣ Метод, который принимает список Int и возвращает строку:
// "empty", если список пуст,
// "one", если один элемент,
// "many", если больше одного
def describeList(nums: List[Int]): String = nums match {
  case Nil        => "empty"
  case _ :: Nil   => "one"
  case _ :: _     => "many"
}
describeList(List(1, 2, 3)) // должно вернуть "many"
describeList(List(1)) // должно вернуть "one"
describeList(List()) // должно вернуть "empty"

// 3️⃣ Метод, который принимает Any и возвращает строку:
// "number", если Int или Double
// "text", если String
// "other", для всего остального
def classify(num: Any): String = num match {
  case i: Int       => "number"
  case d: Double    => "number"
  case s: String    => "text"
  case o            => "other"
}
classify(42) // должно вернуть "number"
classify(42.2) // должно вернуть "number"
classify("scala") // должно вернуть "text"
classify("") // должно вернуть "other"

// 30 - case object
// Объяснение:
// case object в Scala — это особый вариант объекта, который используется вместе
// с sealed trait или sealed abstract class для описания ограниченного множества возможных значений.
// В отличие от case class, case object не принимает параметров. Его часто применяют,
// когда нужно задать фиксированные состояния или варианты без дополнительных данных.
// case object автоматически имеет:
//
// поддержку сравнения по значению,
// удобное использование в pattern matching,
// сериализацию.

// 1️⃣ Метод, который принимает Direction и возвращает строку с направлением
sealed trait Direction
case object North extends Direction

def move(side: Direction): String = side match {
  case North => "Moving up"
}
move(North) // должно вернуть "Moving up"

// 2️⃣ Метод, который принимает Status и возвращает булево значение
// true для Success, false для Failure
sealed trait Status
case object Success extends Status
case object Failure extends Status

def checkStatus(status: Status): Boolean = status match {
  case Success => true
  case Failure => false
}
checkStatus(Success) // должно вернуть true
checkStatus(Failure) // должно вернуть false

// 3️⃣ Метод, который принимает Command и возвращает строку для логов
sealed trait Command
case object Start extends Command
case object Stop extends Command

def execute(command: Command): String = command match {
  case Start => "System starting"
  case Stop => "System stopping"
}
execute(Start) // должно вернуть "System starting"
execute(Stop)

// 31 - trait
// trait — это ключевое слово в Scala, обозначающее механизм для описания абстрактного поведения,
// которое могут реализовывать классы и объекты.
// Traits похожи на интерфейсы в других языках, но мощнее — они могут содержать как абстрактные методы
// (без реализации), так и конкретные методы (с реализацией).
// Класс может наследовать несколько trait’ов (в отличие от обычного наследования одного класса).
// Traits часто используются для модульности, повторного использования кода и реализации полиморфизма.

// 1️⃣ Создать trait Drawable с методом draw() и класс Circle, реализующий его
trait Drawable {
  def draw(text: String): String
}
class Circle extends Drawable {
  def draw(text: String): String = "Hello"
}

// 2️⃣ Создать trait Sound с методом play() и два класса — Dog и Cat, которые реализуют play по-разному
trait Sound {
  def play(): Unit
}
class Dog extends Sound {
  def play(): Unit = println("Dog barks")
}
class Cat extends Sound {
  def play(): Unit = println("Cat meows")
}
new Dog().play()  // Dog barks
new Cat().play()  // Cat meows

// 3️⃣ Создать два trait — Swimmable и Walkable — и класс Duck, который реализует оба
trait Swimmable {
  def swim(): Unit
}
trait Walkable {
  def walk(): Unit
}
class Duck extends Swimmable with Walkable {
  def swim(): Unit = println("Duck swims")
  def walk(): Unit = println("Duck walks")
}
val d = new Duck
d.swim()  // Duck swims
d.walk()  // Duck walks

// 32 - Future
// Future — это механизм для асинхронного выполнения кода в Scala.
// Он позволяет запускать вычисления в отдельном потоке, не блокируя основной поток программы.
// Результат Future становится доступным позже — когда операция завершится.
// Можно использовать методы map, flatMap, foreach для обработки результата без явного ожидания.

// 1️⃣ Метод, который принимает число и возвращает Future[Int], возводящее его в квадрат
def squareAsync(n: Int): Future[Int] = Future {
  n * n
}
val resultSquare = squareAsync(4) // должно вернуть Future(16)
val resultSquareAsync = Await.result(resultSquare, 1.second)

// 2️⃣ Метод, который создаёт Future[String] и добавляет к строке " done" через map
def markDone(task: Future[String]): Future[String] = {
  task.map(_ + " done")
}
val resultMarkDone = (markDone(Future("Task 1"))) // должно вернуть Future("Task done")
val resultMarkDoneAsync = Await.result(resultMarkDone, 1.second)

// 3️⃣ Метод, который создаёт Future[Int] и печатает результат через foreach
def printResult(n: Future[Int]): Unit = {
  n.foreach(println)
}
printResult(Future(10)) // должно вывести 10
