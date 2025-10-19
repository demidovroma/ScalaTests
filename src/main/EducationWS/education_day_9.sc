// 1. Допустим, что владелец кинотеатра хочет посчитать суммарную выручку по списку билетов,
// где каждый билет представлен как (название фильма, цена, возраст зрителя).
// Нужно вернуть сумму всех билетов для взрослых (возраст >= 18) и фильмов с рейтингом выше 7,
// используя List, filter, map и sum.
def totalAdultRevenue(tickets: List[(String, Int, Int)], ratings: Map[String, Double]): Int = {

  ratings.filter(r => r._2 > 7).map(r => tickets.filter(t => t._3 >= 18 && t._1 == r._1).map(_._2).sum).sum

  val sum = for {
    (rTitle, rRating) <- ratings
    (tTitle, tPrice, tAges) <- tickets
    if (rRating > 7 && rTitle == tTitle && tAges >= 18)
  } yield tPrice
  sum.sum

}

totalAdultRevenue(
  List(("Avatar", 10, 20), ("Frozen", 8, 10), ("Matrix", 12, 25)),
  Map("Avatar" -> 8.5, "Frozen" -> 7.0, "Matrix" -> 9.0)
) // 22


// 2. Список сеансов представлен как List[(название фильма, List[Option[Int]])],
// где Option[Int] – количество свободных мест в ряду.
// Нужно вернуть общее количество доступных мест для всех фильмов, игнорируя None,
// используя flatMap, flatten, foldLeft и Option map.
def totalAvailableSeats(sessions: List[(String, List[Option[Int]])]): Int = {
  sessions
    .flatMap(_._2)
    .flatten
    .sum
}

totalAvailableSeats(
  List(
    ("Avatar", List(Some(5), None, Some(3))),
    ("Matrix", List(Some(2), Some(4)))
  )
) // 14


// 3. У нас есть список зрителей List[(имя, List[String])] и список фильмов с рейтингом Map[String, Double].
// Необходимо вернуть Map[String, List[String]] – для каждого фильма список зрителей старше 18 лет,
// которые хотят его посмотреть и рейтинг фильма > 8.
// Использовать for-comprehension, exists, filter, collect и pattern matching OR.
def adultFansByMovie(
  viewers: List[(String, List[String])],
  ratings: Map[String, Double],
  ages: Map[String, Int]
)//: Map[String, List[String]]
= {

  (for {
    (name, movies) <- viewers
    age <- ages.collect { case (`name`, a) if a > 18 => a }
    movie <- movies
    _ <- ratings.collect { case (`movie`, r) if r > 8 => r }
  } yield (movie, name))
    .groupMap(_._1)(_._2)


  // val viewersList = for {
  //   (name, movies)  <- viewers
  //   (title, rating) <- ratings.filter(_._2 > 8)
  //   (aName, aAge)   <- ages.filter(_._2 > 18)
  //   if movies.contains(title)
  //
  // } yield (title, List(name))
  //
  // viewersList
}

adultFansByMovie(
  List(
    ("Alice", List("Avatar","Frozen")),
    ("Bob", List("Matrix","Avatar")),
    ("Clara", List("Frozen"))
  ),
  Map("Avatar" -> 8.5, "Frozen" -> 7.0, "Matrix" -> 9.0),
  Map("Alice" -> 20, "Bob" -> 19, "Clara" -> 25)
) // Map("Avatar" -> List("Alice"), "Matrix" -> List("Bob"))
