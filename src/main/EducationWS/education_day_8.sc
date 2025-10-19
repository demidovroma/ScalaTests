// === List Sum Method ===

// 1. Посчитать общую выручку кинотеатра по списку цен билетов.
def totalRevenue(tickets: List[Int]): Int = {
  tickets.sum
}
totalRevenue(List(10, 15, 20, 10)) // 55

// 2. Найти общую сумму скидок, применённых к билетам.
def totalDiscounts(discounts: List[Int]): Int = {
  discounts.sum
}
totalDiscounts(List(2, 3, 1)) // 6

// 3. Подсчитать общую стоимость всех купленных попкорнов.
def popcornRevenue(prices: List[Int]): Int = {
  prices.sum
}
popcornRevenue(List(5, 5, 10)) // 20


// === List Filter Method ===

// 4. Вернуть список фильмов, которые идут дольше 120 минут.
def longMovies(movies: List[(String, Int)]): List[String] = {
  movies.filter(_._2 > 120).map(_._1)
}
longMovies(List(("Avatar",180),("Toy Story",100))) // List("Avatar")

// 5. Отфильтровать зрителей старше 18 лет.
def adultViewers(viewers: List[(String, Int)]): List[String] = {
  viewers.filter(_._2 >= 18).map(_._1)
}
adultViewers(List(("Alex",17),("Maria",22))) // List("Maria")

// 6. Выбрать фильмы, у которых рейтинг больше 8.
def topRated(movies: List[(String, Double)]): List[String] = {
  movies.filter(_._2 > 8).map(_._1)
}
topRated(List(("Matrix",8.7),("Frozen",7.5))) // List("Matrix")


// === Map for List ===

// 7. Преобразовать список названий фильмов в список длин их названий.
def movieTitleLengths(movies: List[String]): List[Int] = {
  movies.map(_.length)
}
movieTitleLengths(List("Avatar","Matrix")) // List(6,6)

// 8. Увеличить цены билетов на 10%.
def increaseTicketPrices(prices: List[Int]): List[Double] = {
  prices.map(p => p + (p * 10 / 100))
}
increaseTicketPrices(List(10,20)) // List(11.0,22.0)

// 9. Получить список заглавных названий фильмов.
def uppercaseTitles(titles: List[String]): List[String] = {
  titles.map(_.toUpperCase)
}
uppercaseTitles(List("avatar","matrix")) // List("AVATAR","MATRIX")


// === List Flatten ===

// 10. Объединить списки фильмов по жанрам в один общий список.
def mergeGenres(genres: List[List[String]]): List[String] = {
  genres.flatten
}
mergeGenres(List(List("Action","Drama"),List("Comedy"))) // List("Action","Drama","Comedy")

// 11. Из списка списков рейтингов получить общий список всех оценок.
def allRatings(ratings: List[List[Int]]): List[Int] = {
  ratings.flatten
}
allRatings(List(List(8,9), List(7,6))) // List(8,9,7,6)

// 12. Собрать все названия фильмов всех залов в один список.
def allMovies(halls: List[List[String]]): List[String] = {
  halls.flatten
}
allMovies(List(List("Avatar"), List("Matrix","Dune"))) // List("Avatar","Matrix","Dune")


// === flatMap ===

// 13. Для списка фильмов вернуть список всех сеансов.
def allShowtimes(movies: List[(String, List[String])]): List[String] = {
  movies.flatMap(m => m._2)
}
allShowtimes(List(("Avatar",List("10:00","12:00")),("Matrix",List("14:00")))) // List("10:00","12:00","14:00")

// 14. Получить все имена зрителей, купивших билеты на разные фильмы.
def allViewers(tickets: List[(String, List[String])]): List[String] = {
  tickets.flatMap(v => v._2)
}
allViewers(List(("Avatar",List("Anna","Bob")),("Matrix",List("Clara")))) // List("Anna","Bob","Clara")

// 15. Из списка Maybe[List[фильмы]] получить все доступные названия.
def availableMovies(lists: List[Option[List[String]]]): List[String] = {
  lists.flatMap(t => t.toList.flatten)
}
availableMovies(List(Some(List("Avatar")), None, Some(List("Matrix")))) // List("Avatar","Matrix")


// === foldLeft ===

// 16. Подсчитать количество проданных билетов.
def totalTickets(tickets: List[Int]): Int = {
  tickets.foldLeft(0)(_ + _)
}
totalTickets(List(1,2,3,4)) // 10

// 17. Суммировать рейтинг фильмов в Map.
def sumRatings(movies: Map[String, Double]): Double = {
  movies.foldLeft(0.0) {
    case (acc, (_, r)) => acc + r
  }
}
sumRatings(Map("Avatar"->8.5,"Matrix"->9.0)) // 17.5

// 18. Подсчитать общее количество зрителей в списке сеансов.
def totalViewers(sessions: List[List[Int]]): Int = {
  sessions.foldLeft(0)((acc, v) => acc + v.sum)
}
totalViewers(List(List(5,10),List(8,7))) // 30


// === for-comprehension ===

// 19. Вернуть пары (фильм, время), если фильм идёт дольше 100 минут.
def longMovieSessions(movies: List[(String, Int)], sessions: List[String]): List[(String,String)] = {
  for {
    m <- movies
    s <- sessions
    if m._2 > 100
  } yield (m._1, s)
}
longMovieSessions(List(("Avatar",180),("Toy Story",90)), List("10:00","12:00"))
// List(("Avatar","10:00"),("Avatar","12:00"))

// 20. Составить список скидок для фильмов с рейтингом выше 8.
def discountMovies(movies: List[(String, Double)]): List[String] = {
  for {
    m <- movies
    if m._2 > 8
  } yield m._1
}
discountMovies(List(("Avatar",8.7),("Frozen",7.5))) // List("Avatar")

// 21. Получить все комбинации (зритель, фильм) при наличии билета.
def validTickets(viewers: List[String], tickets: List[Option[String]]): List[(String,String)] = {
  for {
    (v, t) <- viewers zip tickets
    movie <- t
  } yield (v, movie)
}
validTickets(List("Alice","Bob"), List(Some("Avatar"), None)) // List(("Alice","Avatar"))


// === exists ===

// 22. Проверить, есть ли фильм с рейтингом выше 9.
def hasTopMovie(movies: List[(String, Double)]): Boolean = {
  movies.exists(_._2 > 9)
}
hasTopMovie(List(("Avatar",8.5),("Matrix",9.2))) // true

// 23. Проверить, покупал ли кто-то билет на фильм "Dune".
def boughtDune(tickets: List[String]): Boolean = {
  tickets.exists(_ == "Dune")
}
boughtDune(List("Avatar","Dune")) // true

// 24. Есть ли хотя бы один пустой зал.
def hasEmptyHall(halls: List[List[String]]): Boolean = {
  halls.exists(_.isEmpty)
}
hasEmptyHall(List(List("Anna"), List())) // true


// === forAll ===

// 25. Проверить, все ли фильмы идут дольше 60 минут.
def allLong(movies: List[Int]): Boolean = {
  movies.forall(_ > 60)
}
allLong(List(120,90,150)) // true

// 26. Проверить, все ли залы заполнены.
def allFilled(halls: List[List[String]]): Boolean = {
  halls.forall(_.nonEmpty)
}
allFilled(List(List("A"), List("B","C"))) // true

// 27. Все ли цены на билеты положительные.
def allPricesPositive(prices: List[Int]): Boolean = {
  prices.forall(_ > 0)
}
allPricesPositive(List(10,20,0)) // false


// === headOption ===

// 28. Получить первый фильм в списке.
def firstMovie(movies: List[String]): Option[String] =  {
  movies.headOption
}
firstMovie(List("Avatar","Matrix")) // Some("Avatar")

// 29. Получить первого зрителя, если список не пуст.
def firstViewer(viewers: List[String]): Option[String] = {
  viewers.headOption
}
firstViewer(List()) // None

// 30. Получить первый зал с более чем 5 зрителями.
def firstLargeHall(halls: List[List[String]]): Option[List[String]] = {
  halls.filter(_.length > 5).headOption
}
firstLargeHall(List(List("A"), List("B","C","D","E","F","G"))) // Some(List("B","C","D","E","F","G"))


// === Option ===

// 31. Вернуть цену билета по названию фильма.
def ticketPrice(movie: String, prices: Map[String, Int]): Option[Int] = {
  prices.find {
    case (title, _) => title == movie
  }.map {
    case (_, price) => price
  }
}
ticketPrice("Avatar", Map("Avatar"->10)) // Some(10)

// 32. Получить рейтинг фильма, если он существует.
def getRating(movie: String, ratings: Map[String, Double]): Option[Double] = {
  ratings.find {
    case (title, _) => title == movie
  }.map {
    case (_, rating) => rating
  }
}
getRating("Matrix", Map("Matrix"->9.0)) // Some(9.0)

// 33. Найти первого зрителя старше 18 лет.
def firstAdult(viewers: List[(String, Int)]): Option[String] = {
  viewers.find {
    case (_, age) => age > 18
  }.map {
    case (name, _) => name
  }
}
firstAdult(List(("Anna",17),("Bob",20))) // Some("Bob")


// === Option map ===

// 34. Увеличить цену найденного билета на 10%.
def increasePrice(price: Option[Int]): Option[Double] = {
  price.map(p => p + (p * 10 / 100))
}
increasePrice(Some(10)) // Some(11.0)

// 35. Добавить " (3D)" к названию фильма, если оно найдено.
def mark3D(movie: Option[String]): Option[String] = {
  movie.map(_ + " (3D)")
}
mark3D(Some("Avatar")) // Some("Avatar (3D)")

// 36. Увеличить рейтинг фильма на 0.1, если он найден.
def boostRating(rating: Option[Double]): Option[Double] = {
  rating.map(_ + 0.1)
}
boostRating(Some(8.5)) // Some(8.6)


// === pattern matching OR ===

// 37. Вернуть "cheap" для цены <10, "medium" для 10–20, "expensive" для >20.
def priceCategory(price: Int): String = price match {
  case p if p < 10 => "cheap"
  case p if p > 10 || p < 20 => "medium"
  case _ => "expensive"
}
priceCategory(15) // "medium"

// 38. Вернуть "popular" если фильм — "Avatar" или "Matrix", иначе "regular".
def classifyMovie(title: String): String = title match {
  case t if t == "Avatar" || t == "Matrix" => "popular"
  case _ => "regular"
}
classifyMovie("Avatar") // "popular"

// 39. Вернуть "open" если статус "Running" или "Open", иначе "closed".
def checkStatus(status: String): String = status match {
  case s if s == "Running" | s == "Open" => "open"
  case _ => "closed"
}
checkStatus("Open") // "open"


// === Option pattern matching ===

// 40. Вернуть текст "Ticket found: X" или "No ticket".
def ticketMessage(ticket: Option[String]): String = ticket match {
  case Some(t) => s"Ticket found: $t"
  case None => "No ticket"
}
ticketMessage(Some("Avatar")) // "Ticket found: Avatar"

// 41. Вернуть "Available" если есть рейтинг, иначе "No rating".
def ratingStatus(rating: Option[Double]): String = rating match {
  case Some(value) => "Available"
  case None => "No rating"
}
ratingStatus(None) // "No rating"

// 42. Вернуть цену с суффиксом "$" если есть, иначе "Not available".
def formatPrice(price: Option[Int]): String = price match {
  case Some(value) => s"${value}$$"
  case None => "Not available"
}
formatPrice(Some(10)) // "10$"


// === List pattern matching ===

// 43. Вернуть "empty" если список фильмов пуст, "single" если один, "multiple" если больше.
def describeMovies(movies: List[String]): String = movies match {
  case Nil => "empty"
  case _ :: Nil => "single"
  case _ => "multiple"
}
describeMovies(List("Avatar","Matrix")) // "multiple"
describeMovies(List()) // "multiple"

// 44. Вернуть название первого фильма, если есть, иначе "no movies".
def firstOrNone(movies: List[String]): String = movies match {
  case m if m.isEmpty => "no movies"
  case m => m.headOption.toString
}
firstOrNone(List()) // "no movies"
firstOrNone(List("Avatar","Matrix"))

// 45. Если в списке билетов первый VIP, вернуть "priority", иначе "regular".
def ticketType(tickets: List[String]): String = tickets match {
  case t if t.headOption.contains("VIP") => "priority"
  case _ => "regular"
}
ticketType(List("VIP","Standard")) // "priority"
