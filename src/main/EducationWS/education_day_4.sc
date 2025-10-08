import java.lang.System.Logger
// День 4
// 19 - Class new
// class в Scala используется для создания собственных типов данных с полями (состоянием) и методами (поведением).
// Чтобы создать экземпляр класса, используется ключевое слово new.
// Экземпляры классов могут хранить данные и предоставлять методы для работы с ними.
// Например, new Person("Alice", 25) создаёт объект с полями имени и возраста.

// 1️⃣ Создать класс Circle с радиусом и методом для вычисления площади круга
// Circle(10).area() // должно вернуть 314 (используй Math.PI, округлять не обязательно)
class Circle(val radius: Int) {
  def area(): Double = Math.PI * radius * radius
}
val radius = new Circle(10)
radius.area()

// 2️⃣ Создать класс Car с маркой и годом выпуска, и методом info, возвращающим строку
// Car("BMW", 2020).info() // должно вернуть "BMW, 2020"
class Car(val brand: String, val year: Int) {
  def info(): String = s"$brand, $year"
}
val car = new Car("BMW", 2020)
car.info()

// 3️⃣ Создать класс BankAccount с балансом и методом deposit(amount),
// который увеличивает баланс и возвращает новый баланс
// BankAccount(1000).deposit(500) // должно вернуть 1500
class BankAccount(val balance: Int) {
  def deposit(deposit: Int): Int = balance + deposit
}
val bank = new BankAccount(1000)
bank.deposit(500)

// 20 - Case Class
// case class в Scala — это особый вид класса, который создаётся для удобной работы с данными.
// В отличие от обычного класса:
// case class автоматически имеет equals, hashCode, toString.
// Создаётся без ключевого слова new (автоматически доступен apply).
// Значения параметров конструктора становятся val по умолчанию.
// Поддерживает удобный pattern matching.

// 1️⃣ Создать case class Book с названием и автором,
// и метод info, который возвращает строку "Название - Автор"
case class Book(title: String, author: String) {
  def info(): String = s"$title - $author"
}
Book("1984", "Orwell").info() // должно вернуть "1984 - Orwell"

// 2️⃣ Создать case class Rectangle с длиной и шириной,
// и метод area, который возвращает площадь прямоугольника
case class Rectangle(length: Int, width: Int) {
  def area(): Int = length * width
}
Rectangle(5, 10).area() // должно вернуть 50

// 3️⃣ Создать case class User с именем и возрастом,
// и метод isAdult, который возвращает true если возраст >= 18
case class User(name: String, age: Int) {
  def isAdult: Boolean = age >= 18
}
User("Bob", 20).isAdult // должно вернуть true
User("Tom", 15).isAdult // должно вернуть false

// 21 - objects
// В Scala object — это синглтон: единственный экземпляр объекта в программе.
// Его можно использовать для хранения утилитарных методов, констант или как синглтон-ресурс,
// доступный без создания экземпляра класса.

// 1️⃣ Создать объект Config с методом getVersion, который возвращает "1.0.0"
object Config {
  def getVersion: String = "1.0.0"
}
Config.getVersion // должно вернуть "1.0.0"

// 2️⃣ Создать объект Counter с переменной count и методом increment, который увеличивает count на 1
object Counter {
  def create(count: Int = 0): Counter = Counter(count)
}

case class Counter(count: Int) {
  def increment: Counter = copy(count = count + 1)
}

val c1 = Counter.create()
val c2 = c1.increment

// 3️⃣ Создать объект StringUtils с методом reverse, который переворачивает строку
object StringUtils {
  def reverse(str: String): String = str.reverse
}
StringUtils.reverse("Scala") // должно вернуть "alacS"

// 22 - companion objects
// Companion object — это объект, который имеет то же имя, что и класс,
// и может обращаться к его приватным полям и методам. Обычно используется для фабричных методов,
// статических членов или вспомогательных функций.

// 1️⃣ Создать класс Student с полями name и grade,
// и companion object с методом apply для создания студента с default grade = 1
class Student(val name: String, val grade: Int)

object Student {
  def apply(name: String): Student = new Student(name, 1)
}
val roma = Student("Roma")  // grade автоматически 1
println(roma.name)  // Roma
println(roma.grade) // 1

// 2️⃣ Создать класс Rectangle с длиной и шириной,
// и companion object с методом square(side: Int), создающим прямоугольник с равными сторонами
class RectangleNew(val length: Int, val width: Int)

object RectangleNew {
  def square(side: Int): RectangleNew =  new RectangleNew(side, side)
}
val c = RectangleNew.square(10)
println(c.length)
println(c.width)

// 3️⃣ Создать класс Logger с полем level,
// и companion object с методом defaultLogger, который возвращает Logger с level = "INFO"
class Logger(val level: String)

object Logger {
  def defaultLogger: Logger = new Logger("INFO")
}
val logger = Logger.defaultLogger
println(logger.level)

// 23 - apply
// Метод apply в Scala позволяет создавать объекты или вызывать функциональность объекта так,
// будто это обычный вызов функции, без явного использования new.
// Он часто используется в companion объектах для удобного создания экземпляров
// класса или реализации фабрик объектов.

// 1️⃣ Реализовать apply в объекте Logger, чтобы при вызове Logger("DEBUG") создавался Logger с уровнем "DEBUG"
class LoggerNew(val level: String)
object LoggerNew {
  def apply(level: String): LoggerNew = new LoggerNew(level)
}
val log = LoggerNew("DEBUG")
println(log.level)

// 2️⃣ Реализовать apply в companion object класса Circle, чтобы можно было создавать Circle с радиусом по умолчанию 1
class Circle(val radius: Int)
object Circle {
  def apply(): Circle = new Circle(1)
}
val c = Circle()
println(c.radius)

// 3️⃣ Создать объект StringOps с apply, который принимает строку и возвращает её длину
object StringOps {
  def apply(str: String):Int = str.length
}
val strLength = StringOps("Test")

