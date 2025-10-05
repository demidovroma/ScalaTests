// 1 Values

// 1️⃣ Создать val с именем age и присвоить ему число 25
val age = 25 // должно вернуть 25

// 2️⃣ Создать val с именем name и присвоить ему строку "Roman"
val name = "Roman" // должно вернуть "Roman"

// 3️⃣ Создать val с именем isScalaFun и присвоить true
val isScalaFun = true // должно вернуть true

// 2 difference between val и lazy val and def

// 1️⃣ val: создаём константу, значение вычисляется сразу
// Попробуй объявить val, изменить её и посмотреть что произойдёт
val pi = 3.14
pi // должно вернуть 3.14

// 2️⃣ lazy val: значение вычисляется только при первом обращении
// Объяви lazy val, напиши println внутри вычисления, чтобы увидеть когда оно выполняется
lazy val greeting = { println("Вычисляем greeting"); "Hello" }
greeting // должно вывести "Вычисляем greeting" и вернуть "Hello"

// 3️⃣ def: метод, вычисляется каждый раз при вызове
// Объяви def с println внутри и вызови дважды
def randomNumber = { println("Вычисляем число"); scala.util.Random.nextInt(10) }
randomNumber // должно вывести "Вычисляем число" и вернуть число
randomNumber // снова вывод "Вычисляем число" и новое число

// 4 String Interpolation

// 1️⃣ Вставить имя и возраст в строку
// Использовать s-интерполяцию
val name = "Bob"
val age = 25
s"Hello, my name is $name and I am $age years old" // должно вернуть "Hello, my name is Bob and I am 25 years old"

// 2️⃣ Вставить число с форматированием
// Использовать f-интерполяцию, 1 знак после запятой
val speed = 123.456
f"Current speed is $speed%.1f km/h" // должно вернуть "Current speed is 123.5 km/h"

// 3️⃣ Показать raw-строку с обратным слешем
raw"Path to file: C:\Users\Bob\Documents" // должно вернуть "Path to file: C:\Users\Bob\Documents"

// 5 Methods

// 1️⃣ Написать метод, который возвращает приветствие с именем
// Вход: name: String
// Выход: String
// Пример вызова: greet("Alice") // должно вернуть "Hello, Alice!"

def greet (str: String): String = s"Hello, $str!"
greet("Alice")

// 2️⃣ Написать метод, который возвращает квадрат числа
// Вход: n: Int
// Выход: Int
// Пример вызова: square(5) // должно вернуть 25

def square(n: Int): Int = n * n
square(5)

// 3️⃣ Написать метод, который проверяет, является ли число чётным
// Вход: n: Int
// Выход: Boolean
// Пример вызова: isEven(4) // должно вернуть true
def isEven(n: Int): Boolean = (n % 2 == 0)
isEven(4)

// 6 Method with Arguments

// 1️⃣ Написать метод, который принимает два числа и возвращает их сумму
// Вход: a: Int, b: Int
// Выход: Int
// Пример вызова: sum(3, 5) // должно вернуть 8
def sum(a: Int, b: Int): Int = a + b
sum(3, 5)

// 2️⃣ Написать метод, который принимает имя и возраст и возвращает строку
// Вход: name: String, age: Int
// Выход: String
// Пример вызова: personInfo("Bob", 30) // должно вернуть "Bob is 30 years old"
def personInfo(name: String, age: Int): String = s"$name is $age years old"
personInfo("Bob", 30)

// 3️⃣ Написать метод, который принимает список чисел и число multiplier,
// возвращает новый список, где каждый элемент умножен на multiplier
// Вход: nums: List[Int], multiplier: Int
// Выход: List[Int]
// Пример вызова: multiplyList(List(1,2,3), 2) // должно вернуть List(2,4,6)
def multiplyList(nums: List[Int], multiplier: Int): List[Int] = nums.map(_ * multiplier)
multiplyList(List(1,2,3), 2)

// 7 — main

// 1️⃣ Написать программу с main, которая выводит "Hello, World!"
// Пример вызова: запуск main должен вывести "Hello, World!"
def main(): Unit = {
  println("Hello, World!")
}
main();

// 2️⃣ Написать программу с main, которая принимает аргументы командной строки и выводит их в одну строку
// Пример вызова: main(Array("Scala", "Fun")) // вывод: "Scala Fun"
def main(strings: Array[String]): Unit = {
  println(strings.mkString(" "))
}
main(Array("Scala", "Fun"))

// 3️⃣ Написать программу с main, которая создаёт список чисел и выводит их сумму
// Пример вызова: main(Array()) // вывод: 1 + 2 + 3 + 4 +
def main(nums: Array[Int]): Unit = {
  println(s"Сумма: ${nums.sum}")
}
main(Array(1,2,3,4))

// Итог дня

// 1️⃣ Values
// Создать значения
// age: Int, name: String, isScalaFun: Boolean
// После определения, их можно просто вывести
val age = 25
val name = "Roman"
val isScalaFun = true

println(age)
println(name)
println(isScalaFun)

// 2️⃣ difference between val
// Создать val и var, попробовать изменить их значения
val name = "Roman" // недбзя изменить
var name2 = "Roman" // можно изменить
name2 = "Alice"
println(name2)

// 3️⃣ lazy val and def
// lazy val и def
// println(...) несколько раз
lazy val greeting = { println("Вычисляем greeting"); scala.util.Random.nextInt(10) }
greeting
greeting

def randomNumber = { println("Вычисляем число"); scala.util.Random.nextInt(10) }
randomNumber
randomNumber

// 4️⃣ String Interpolation
// Напиши метод, который принимает имя и возраст, и возвращает строку: "Привет, Roman! Тебе 38 лет."
// greetPerson("Roman", 38) // должно вернуть "Привет, Roman! Тебе 38 лет."
def greetPerson (name: String, age: Int): String = {
  s"Привет, $name! Тебе $age лет."
}
greetPerson("Roman", 38)

// 5️⃣ Methods
// Напиши метод, который принимает число и возвращает его квадрат.
def square(n: Int): Int = {
  n * n
}
square(5) // должно вернуть 25

// 6️⃣ Method with Arguments
// Напиши метод, который принимает два числа и возвращает их сумму.
def sum(a: Int, b: Int): Int = {
  a + b
}
sum(3, 7) // должно вернуть 10

// 7️⃣ main
// Напиши программу с main, которая выводит "Hello, Scala!".
def main(nums: Array[Int]): Unit = {
  println("Hello, Scala!")
}
main(Array()) // вывод: Hello, Scala!

// С подвохом
val name: String = "Roman"
lazy val age: Int = { println("Вычисляем возраст"); 38 }

def greet(name: String, age: Int): String = {
  s"Привет, $name! Тебе $age лет."
}

def squareAge(age: Int): Int = {
  age * age
}

greet(name, age)          // должно вывести: "Привет, Roman! Тебе 38 лет."
squareAge(age)            // должно вернуть 1444
squareAge(age)            // должно вернуть 1444 (и не должно печатать "Вычисляем возраст" снова)



