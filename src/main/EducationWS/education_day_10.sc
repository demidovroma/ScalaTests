// 4. Владелец кинотеатра хочет узнать среднюю цену билета по каждому фильму.
// Данные представлены как List[(String, List[Int])], где первый элемент — название фильма, а второй — список цен на билеты.
// Нужно вернуть Map[String, Double] — среднюю цену для каждого фильма. Использовать map, foldLeft и pattern matching.
def avgTicketPriceByMovie(data: List[(String, List[Int])]): Map[String, Double] = {
  val avg = data.map {
    case (title, prices) => (title, (prices.sum.toDouble / prices.length))
  }
  avg.toMap
}

avgTicketPriceByMovie(
  List(
    ("Avatar", List(10, 12, 14)),
    ("Matrix", List(8, 9)),
    ("Frozen", List(6, 6, 7, 5))
  )
) // Map("Avatar"->12.0, "Matrix"->8.5, "Frozen"->6.0)


// 5. У нас есть список фильмов List[(String, Option[Int])] — название и рейтинг (может отсутствовать).
// Нужно вернуть список названий фильмов, у которых рейтинг есть и он больше 8.
// Использовать collect, Option pattern matching и filter.
def topRatedMovies(movies: List[(String, Option[Int])]): List[String] = {
  movies.collect {
    case (title, Some(value)) if value > 8 => title
  }
}

topRatedMovies(
  List(("Avatar", Some(9)), ("Matrix", Some(10)), ("Frozen", None))
) // List("Avatar","Matrix")


// 6. Кассир записывает количество проданных билетов в виде списка List[Option[Int]].
// Если подряд встречаются две None — это ошибка записи, нужно вернуть None.
// В противном случае вернуть сумму всех Some. Использовать foldLeft, exists, headOption и pattern matching.
def validateAndSumTickets(sales: List[Option[Int]]): Option[Int] = {
  if (sales.sliding(2).exists(pair => pair.forall(_.isEmpty))) None
  else Some(sales.flatten.sum)
}

validateAndSumTickets(List(Some(10), None, Some(5))) // Some(15)
validateAndSumTickets(List(Some(10), None, None, Some(3))) // None


// 7. В кинотеатре данные по сеансам хранятся как List[List[String]], где каждый вложенный список — это фильмы,
// идущие в одном зале.
// Нужно вернуть один список всех фильмов без дубликатов. Использовать flatten, distinct и for-comprehension.
def allUniqueMovies(sessions: List[List[String]]): List[String] = {
  sessions.flatten.distinct
}

allUniqueMovies(
  List(
    List("Avatar", "Matrix"),
    List("Matrix", "Frozen"),
    List("Avatar", "Titanic")
  )
) // List("Avatar","Matrix","Frozen","Titanic")


// 8. Список фильмов с количеством свободных мест представлен как List[(String, Int)].
// Нужно вернуть true, если все фильмы имеют больше 0 свободных мест, иначе false. Использовать forAll.
def allMoviesAvailable(movies: List[(String, Int)]): Boolean = {
  movies.forall(m => m._2 > 0)
}

allMoviesAvailable(List(("Avatar", 5), ("Matrix", 2), ("Frozen", 0))) // false
allMoviesAvailable(List(("Avatar", 3), ("Matrix", 1))) // true


// 9. Клиент выбирает фильм, и у нас есть Option[List[String]] — список доступных фильмов или None,
// если база недоступна.
// Нужно вернуть первый фильм (headOption), если список не пуст,
// иначе вернуть строку "Нет доступных фильмов".
// Использовать Option map и pattern matching.
def getFirstAvailableMovie(maybeMovies: Option[List[String]]): String = {
  maybeMovies
    .flatMap(_.headOption)
    .getOrElse("Нет доступных фильмов")
}

getFirstAvailableMovie(Some(List("Avatar", "Matrix"))) // "Avatar"
getFirstAvailableMovie(Some(Nil))                      // "Нет доступных фильмов"
getFirstAvailableMovie(None)                           // "Нет доступных фильмов"


// 10. Кинотеатр хранит отзывы зрителей в виде List[Option[Int]],
// где Int — оценка от 1 до 10, а None — отсутствие отзыва.
// Нужно посчитать среднюю оценку, игнорируя None.
// Если нет ни одной оценки — вернуть None. Использовать flatten и foldLeft.
def averageRating(reviews: List[Option[Int]]): Option[Double] = {
  val rating = reviews.flatten

  if(rating.isEmpty) None
  else Some(rating.sum.toDouble / rating.length)
}

averageRating(List(Some(8), None, Some(10), Some(6))) // Some(8.0)
averageRating(List(None, None))                       // None


// 11. Список фильмов и их жанров представлен как List[(String, String)].
// Вернуть Map[String, List[String]], где ключ — жанр,
// а значение — список фильмов этого жанра. Использовать groupBy и mapValues.
def groupMoviesByGenre(movies: List[(String, String)]): Map[String, List[String]] = {
  movies.groupMap(_._2)(_._1)
}

groupMoviesByGenre(List(
  ("Avatar", "Sci-Fi"),
  ("Matrix", "Sci-Fi"),
  ("Frozen", "Animation")
)) // Map("Sci-Fi" -> List("Avatar","Matrix"), "Animation" -> List("Frozen"))


// 12. Есть список фильмов List[String] и функция def isPopular(movie: String): Boolean.
// Нужно вернуть первый популярный фильм, если такой есть, иначе None.
def firstPopularMovie(movies: List[String], isPopular: String => Boolean): Option[String] = {
  movies.find(isPopular) match {
    case someMovie @ Some(_) => someMovie
    case None                => None
  }
}

def isPopular(movie: String): Boolean = List("Avatar", "Matrix").contains(movie)

firstPopularMovie(List("Titanic", "Matrix", "Frozen"), isPopular) // Some("Matrix")
firstPopularMovie(List("Unknown", "Indie"), isPopular)            // None


// 13. Список билетов представлен как List[(String, Option[Double])],
// где String — название фильма, а Option[Double] — цена билета (может быть None, если цена не указана).
// Вернуть общую сумму всех указанных цен. Использовать flatMap и sum.
def totalDefinedTicketPrice(tickets: List[(String, Option[Double])]): Double = {
  tickets.flatMap(t => t._2).sum
}

totalDefinedTicketPrice(List(("Avatar", Some(12.5)), ("Matrix", None), ("Frozen", Some(10.0)))) // 22.5


// 14. Список сеансов представлен как List[(String, Int)], где String — название фильма,
// а Int — количество зрителей.
// Вернуть список названий фильмов, у которых посещаемость больше среднего значения по всем сеансам.
// Использовать foldLeft и filter.
def popularSessions(sessions: List[(String, Int)]): List[String] = {
  val popular = sessions.map( s => s._2).sum / sessions.length
  sessions.filter(s => s._2 > popular).map(s => s._1)
}

popularSessions(List(("Avatar", 120), ("Matrix", 80), ("Frozen", 100))) // List("Avatar")


// 15. В кинотеатре идут фильмы разных жанров. Даны два списка:
// val nowShowing = List("Avatar", "Matrix", "Frozen")
// val upcoming = List("Matrix", "Dune", "Inside Out")
// Нужно вернуть список фильмов, которые идут сейчас или скоро будут идти (без дубликатов).
// Использовать pattern matching и flatten.
def uniqueMovies(nowShowing: List[String], upcoming: List[String]): List[String] = {
  List(nowShowing, upcoming).flatten match {
    case all => all.distinct
  }
}

uniqueMovies(List("Avatar", "Matrix", "Frozen"), List("Matrix", "Dune", "Inside Out")) // List("Avatar", "Matrix", "Frozen", "Dune", "Inside Out")


// 16. У нас есть список залов: List[(String, Int)], где String — название зала, Int — количество свободных мест.
// Нужно вернуть Option[String] — название первого зала, где свободных мест больше 50.
// Использовать headOption и filter.
def firstLargeHall(halls: List[(String, Int)]): Option[String] = {
  halls.filter(h => h._2 > 50).map(_._1).headOption
}

firstLargeHall(List(("Red", 30), ("Blue", 60), ("Gold", 45))) // Some("Blue")


// 17. Кинотеатр продаёт билеты разных типов: List[(String, Double)],
// где String — тип билета ("adult", "child", "vip").
// Нужно вернуть Map[String, Double] со средней ценой каждого типа.
// Использовать groupBy, mapValues и foldLeft.
def averageTicketPriceByType(tickets: List[(String, Double)]): Map[String, Double] = {
  tickets
    .groupBy(_._1)
    .view
    .mapValues { list =>
      val (sum, count) = list.foldLeft((0.0, 0)) { case ((acc, n), (_, price)) =>
        (acc + price, n + 1)
      }
      sum / count
    }
    .toMap
}

averageTicketPriceByType(List(("adult", 10.0), ("child", 5.0), ("adult", 12.0))) // Map("adult" -> 11.0, "child" -> 5.0)


// 18. Список фильмов: List[Option[String]]. Нужно вернуть строку с названиями фильмов через запятую,
// пропуская None. Использовать collect и mkString.
def joinAvailableMovies(movies: List[Option[String]]): String = {
  movies.collect {
    case Some(value) => value
  }.mkString(", ")
}

joinAvailableMovies(List(Some("Avatar"), None, Some("Matrix"))) // "Avatar, Matrix"


// 19. У нас есть список залов кинотеатра: List[(String, Option[Int])],
// где Int — количество проданных билетов.
// Нужно вернуть общее количество проданных билетов, игнорируя залы, где значение None.
// Использовать flatten и sum.
def totalTicketsSold(halls: List[(String, Option[Int])]): Int = {
  halls.flatten {
    case (title, value) => value
  }.sum
}
totalTicketsSold(List(("Red", Some(50)), ("Blue", None), ("Gold", Some(80)))) // 130


// 20. Дана информация о фильмах: List[(String, Int, Double)],
// где String — название, Int — длительность, Double — рейтинг.
// Нужно вернуть названия фильмов, у которых рейтинг выше 8.0 и длительность меньше 120 минут.
// Использовать filter и map.
def filterTopShortMovies(movies: List[(String, Int, Double)]): List[String] = {
  movies.filter(m => m._3 > 8.0 & m._2 < 120 ).map(m => m._1)
}
filterTopShortMovies(List(("Avatar", 180, 8.5), ("Soul", 100, 8.3), ("Batman", 110, 7.8))) // List("Soul")


// 21. У кинотеатра есть список расписаний на день: List[List[String]],
// где каждый внутренний список — фильмы в конкретном зале.
// Нужно вернуть один общий список всех фильмов без дубликатов.
// Использовать flatten и distinct.
def allMovies(schedule: List[List[String]]): List[String] = {
  schedule.flatten.distinct
}
allMovies(List(List("Avatar", "Batman"), List("Batman", "Matrix"), List("Soul"))) // List("Avatar", "Batman", "Matrix", "Soul")


// 22. Дана информация о билетах: List[Option[Double]].
// Нужно вернуть среднюю стоимость всех доступных билетов, игнорируя None.
def averageTicketPrice(tickets: List[Option[Double]]): Double = {
  val available = tickets.collect { case (Some(value)) => value }
  available.sum / available.length
}
averageTicketPrice(List(Some(10.0), None, Some(15.0), Some(20.0))) // 15.0


// 23. Список отзывов о фильмах: List[String].
// Нужно вернуть только те отзывы, которые содержат слово "отлично".
def positiveReviews(reviews: List[String]): List[String] = {

  reviews.filter(r => r.toLowerCase.contains("отлично"))

  // for {
  //   r <- reviews
  //   if r.toLowerCase.contains("отлично")
  // } yield r

}
positiveReviews(List("Фильм отлично снят", "Средний фильм", "Отлично играют актеры")) // List("Фильм отлично снят", "Отлично играют актеры")


// 24. Данные о сеансах: List[(String, Int, Option[Int])],
// где String — фильм, Int — зал, Option[Int] — количество свободных мест.
// Нужно вернуть список фильмов, у которых осталось меньше 10 свободных мест.
def almostFullMovies(sessions: List[(String, Int, Option[Int])]): List[String] = {
  sessions.collect {
    case (t, h, Some(s)) if s < 10 => t
 }
}
almostFullMovies(List(("Avatar", 1, Some(12)), ("Matrix", 2, Some(8)), ("Soul", 3, Some(5)), ("Batman", 4, None))) // List("Soul")


// 25. Даны списки фильмов и их жанров: List[(String, String)].
// Нужно вернуть Map жанр -> список фильмов этого жанра.
def moviesByGenre(films: List[(String, String)]): Map[String, List[String]] = {
  films
    .groupBy(_._2)
    .view.mapValues(_.map(_._1))
    .toMap
}
moviesByGenre(List(("Inception", "Sci-Fi"), ("Interstellar", "Sci-Fi"), ("Coco", "Animation")))
// Map("Sci-Fi" -> List("Inception", "Interstellar"), "Animation" -> List("Coco"))


// 26. Список сеансов: List[(String, Int)], где String — название фильма, Int — число проданных билетов.
// Нужно вернуть общее число проданных билетов по всем фильмам.
def totalTicketsSold(sessions: List[(String, Int)]): Int = {
  sessions.map(_._2).sum

  // val summary = for {
  //   (m, t) <- sessions
  // } yield t
  //
  // summary.sum
}
totalTicketsSold(List(("Inception", 120), ("Coco", 80))) // 200


// 27. Список отзывов: List[Option[String]].
// Нужно вернуть количество отзывов, которые не пустые и содержат слово "хорошо".
def countPositiveFeedback(feedback: List[Option[String]]): Int = {
  feedback.flatten.count(_.toLowerCase.contains("хорош"))
}
countPositiveFeedback(List(Some("Фильм хороший"), None, Some("Очень хорошо сыграли актеры"))) // 2


// 28. Список фильмов с рейтингами: List[(String, Double)]. Нужно вернуть список фильмов с рейтингом выше 8.0.
def topRatedMovies(films: List[(String, Double)]): List[String] = {
  films.filter(_._2 > 8.0).map(f => f._1)
}
topRatedMovies(List(("Inception", 8.8), ("Coco", 7.8), ("Interstellar", 8.6))) // List("Inception", "Interstellar")


// 29. Список сеансов: List[(String, Int)], где Int — число свободных мест.
// Нужно проверить, есть ли хотя бы один фильм с доступными местами (>0).
def anyAvailableSeats(sessions: List[(String, Int)]): Boolean = {
  sessions.exists(_._2 > 0)
}
anyAvailableSeats(List(("Inception", 0), ("Coco", 5))) // true


// 30. Список фильмов: List[String].
// Нужно вернуть первый фильм, название которого длиннее 6 символов, если такой есть.
def firstLongMovie(films: List[String]): Option[String] = {
  films.filter(_.length > 6).headOption
}
firstLongMovie(List("Up", "Coco", "Interstellar")) // Some("Interstellar")



















