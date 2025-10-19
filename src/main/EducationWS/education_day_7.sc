import scala.annotation.tailrec

// 1. Допустим, что владелец кафе попросил нас написать функцию для подсчета суммы заказа на основании меню.
// Меню заведения хранится как List[(String, Int)], где String – название блюда, Int – его стоимость.
// Функция должна принимать заказ клиента в виде списка названий блюд и выводить сумму заказа.
def getPriceByOrder(order: List[String], menu: List[(String, Int)]): Int = {
  order.flatMap(i => menu.find(i == _._1).toList).map(_._2).sum
}
getPriceByOrder(List("latte", "cake"), List(("latte", 5), ("cake", 3), ("tea", 2))) // Должно вернуть 8

// 2. Напишите функцию, которая принимает список заказов (каждый заказ – список названий блюд)
// и возвращает список сумм каждого заказа.
def getAllOrdersPrice(orders: List[List[String]], menu: List[(String, Int)]): List[Int] = {
  for {
    order <- orders
  } yield order.flatMap(i => menu.find(i == _._1).toList).map(_._2).sum
}
getAllOrdersPrice(List(List("latte", "cake"), List("tea")), List(("latte", 5), ("cake", 3), ("tea", 2))) // List(8,2)

// 3. Функция принимает список цен продуктов и должна вернуть кортеж: (минимальная цена, максимальная цена, средняя цена).
def priceStats(prices: List[Int]): (Int, Int, Double) = {
  val minPrice = prices.min
  val maxPrice = prices.max
  val avgPrice = prices.sum.toDouble / prices.length
  (minPrice, maxPrice, avgPrice)
}
priceStats(List(5, 10, 15, 20)) // (5,20,12.5)

// 4. Список сотрудников с их возрастом List[(String, Int)].
// Вернуть список имен тех, кто старше 30 лет и чьи имена начинаются с "A".
def filterEmployees(employees: List[(String, Int)]): List[String] = {
  for {
    (name, age) <- employees
    if name.startsWith("A")
    if age > 30
  } yield name
}
filterEmployees(List(("Alice", 35), ("Bob", 28), ("Anna", 40))) // List("Alice","Anna")

// 5. Допустим, есть меню как Map[String, Int] для ускоренного поиска.
// Напишите функцию, которая возвращает сумму заказа, если все позиции есть, иначе None.
def getPriceSafe(order: List[String], menu: Map[String, Int]): Option[Int] = {
  order.foldLeft(Option(0)) {
    (acc, item) =>
      for {
        sum <- acc
        price <- menu.get(item)
      } yield sum + price
  }
}
getPriceSafe(List("latte", "cake"), Map("latte"->5, "cake"->3)) // Some(8)
getPriceSafe(List("latte", "cookie"), Map("latte"->5, "cake"->3)) // None

// 6. У нас есть List[List[Int]] – счета клиентов за день.
// Посчитайте среднюю сумму каждого клиента и верните список средних значений.
def avgPerClient(bills: List[List[Int]]): List[Double] = {
  bills.map(bill => bill.sum.toDouble / bill.length)
}
avgPerClient(List(List(5,10), List(3,7,8))) // List(7.5, 6.0)

// 7. Дан список List[Option[Int]].
// Вернуть сумму всех Some, игнорируя None, но если None встречается подряд дважды, вернуть None.
def sumWithDoubleNoneCheck(opts: List[Option[Int]]): Option[Int] = {
  if (opts.sliding(2).exists(pair => pair.forall(_.isEmpty))) None
  else Some(opts.flatten.sum)
}
sumWithDoubleNoneCheck(List(Some(1), None, Some(3))) // Some(4)
sumWithDoubleNoneCheck(List(Some(1), None, None, Some(3))) // None

// 8. Дан список заказов List[(String, Int)] – название блюда и количество.
// Функция должна вернуть Map с суммарным количеством каждого блюда.
def countEachDish(orders: List[(String, Int)]): Map[String, Int] = {
  orders
    .groupMap(_._1)(_._2)
    .view.mapValues(_.sum).toMap
}
countEachDish(List(("latte",2),("cake",1),("latte",3))) // Map("latte"->5,"cake"->1)

// 9. Дан список чисел List[Int].
// Вернуть список уникальных пар (a,b), где a < b и сумма a+b чётная.
def evenSumPairs(nums: List[Int]): List[(Int, Int)] = {
  @tailrec
  def loop(remaining: List[Int], acc: List[(Int, Int)]): List[(Int, Int)] = {
    remaining match {
      case Nil => acc
      case x :: xs =>
        val pairs = xs.filter(y => (x + y) % 2 == 0).map(y => (x, y))
        loop(xs, acc ++ pairs)
    }
  }

  loop(nums, Nil)
}
evenSumPairs(List(1,2,3,4)) // List((1,3),(2,4))

// 10. Дан список строк. Напишите функцию, которая группирует строки по первой букве,
// возвращает Map[Char,List[String]], но только для букв, встречающихся более 1 раза.
def groupByFirstLetter(words: List[String]): Map[Char, List[String]] = {
  val grouped = words.collect {
    case s if s.nonEmpty => s(0) -> s
  }.groupMap(_._1)(_._2)

  grouped.filter { case (_, list) => list.size > 1 }
}
groupByFirstLetter(List("apple","art","banana","ball","cat")) // Map('a'->List("apple","art"), 'b'->List("banana","ball"))
