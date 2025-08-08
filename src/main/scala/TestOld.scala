object TestOld {

  def mainOld (args: Array[String]): Unit = {
//    Task1
//    Task2
//    Task3
//    Task4
//    Task5
//    Task6 // Не сделал
//    Task7
//    Task8
//    Task9 // Не сделал
//    Task10 // Не завершена
//    Task11
//    Task12
//    Task13 // Надо разобраться
//    Task14
  }

  object Task1 {
    def solution(nums: Array[Int], target: Int): Array[Int] = {

      if (nums.length == 2 && nums.sum == target)
        nums.indices.toArray
      else
        nums.combinations(2).toList.filter(s => s.sum == target).flatten.map(x => nums.indexOf(x)).toArray

    }

    println(s"Task 1 = ${solution(Array(2, 7, 11, 15), 9).toList}")
    // Task 1 = List(0, 1)

    println(s"Task 1 = ${solution(Array(3, 2, 4), 6).toList}")
    // Task 1 = List(1, 2)

    println(s"Task 1 = ${solution(Array(3, 3), 6).toList}")
    // Task 1 = List(0, 1)
  }

  object Task2 {
    def solution(x: Int): Boolean = {
      if (x < 0) return false

      var num = x
      var revers = 0

      while (num != 0) {
        val lastDigit = num % 10
        revers = revers * 10
        revers += lastDigit
        num /= 10
      }

      x == revers
    }

    println(s"Task 2 = ${solution(121)}")
    // Task 2 = true

    println(s"Task 2 = ${solution(-121)}")
    // Task 2 = false

    println(s"Task 2 = ${solution(10)}")
    // Task 2 = false

    println(s"Task 2 = ${solution(-101)}")
    // Task 2 = false
  }

  object Task3 {
    def solution(s: String): Int = {
      s.split(" ").last.length
    }

    println(s"Task 3 = ${solution("Hello World")}")
    // Task 3 = 5
  }

  object Task4 {
    def solution(nums: Array[Int], target: Int): Int = {
      nums.indexOf(target)
    }

    println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 0)}")
    // Task 4 = 4

    println(s"Task 4 = ${solution(Array(4, 5, 6, 7, 0, 1, 2), 3)}")
    // Task 4 = -1

    println(s"Task 4 = ${solution(Array(1), 0)}")
    // Task 4 = -1
  }

  object Task5 {
    def solution(nums: Array[Int]): List[List[Int]] = {
      nums.flatMap(i => nums.toList.combinations(i)).toList :+ List()
    }

    println(s"Task 5 = ${solution(Array(1, 2, 3))}")
    // Task 5 = List(
    //   List(3),
    //   List(1),
    //   List(2),
    //   List(1, 2, 3),
    //   List(1, 3),
    //   List(2, 3),
    //   List(1, 2),
    //   List()
    // )
  }

  object Task6 {
    case class ListNode(
                         x: Int = 0,
                         next: Option[ListNode] = None
                       )

    def solution(l1: ListNode, l2: ListNode): ListNode = {

      l1
    }

    println(s"Task 6 = ${solution(ListNode(2, Some(ListNode(4, Some(ListNode(3))))), ListNode(5, Some(ListNode(6, Some(ListNode(4))))))}")
    // Task 6 = ListNode(7, Some(ListNode(0, Some(ListNode(8, None)))))

    println(s"Task 6 = ${solution(ListNode(), ListNode())}")
    // Task 6 = ListNode(0, None)

    println(s"Task 6 = ${
      solution(
        ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9))))))))))))),
        ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9)))))))
      )
    }")
    // Task 6 = ListNode(8, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(0, Some(ListNode(0, Some(ListNode(0, Some(ListNode(1, None)))))))))))))))
  }

  object Task7 {
    def solution(nums: Array[Int]): Boolean = {
      var index = nums.head
      for (i <- nums.indices by index) {
        if(nums(i) != nums.last) index += i
      }
      index == nums.length-1
    }

    println(s"Task 7 = ${solution(Array(2, 3, 1, 1, 4))}")
    // Task 7 = true

    println(s"Task 7 = ${solution(Array(3, 2, 1, 0, 4))}")
    // Task 7 = false

    println(s"Task 7 = ${solution(Array(3, 2, 3, 0, 0, 0))}")
    // Task 7 = true
  }

  object Task8 {
    def solution(s: String): Int = {
      s.toSet.mkString.length
    }

    println(s"Task 8 = ${solution("abcabcbb")}")
    // Task 8 = 3

    println(s"Task 8 = ${solution("bbbbb")}")
    // Task 8 = 1

    println(s"Task 8 = ${solution("pwwkew")}")
    // Task 8 = 3

    println(s"Task 8 = ${solution("")}")
    // Task 8 = 0
  }

  object Task9 {
    def solution(s: String, p: String): Boolean = {
      // Создаем двумерный массив для хранения результатов
      val dp = Array.fill(s.length + 1, p.length + 1)(false)

      // Пустая строка соответствует пустому шаблону
      dp(0)(0) = true

      // Обрабатываем случай, когда шаблон содержит символы *, которые могут соответствовать пустой строке
      for (j <- 1 to p.length) {
        if (p(j - 1) == '*') {
          dp(0)(j) = dp(0)(j - 2) // * может соответствовать пустой строке
        }
      }

      // Заполняем таблицу dp
      for (i <- 1 to s.length) {
        for (j <- 1 to p.length) {
          if (p(j - 1) == s(i - 1) || p(j - 1) == '.') {
            dp(i)(j) = dp(i - 1)(j - 1) // Символы совпадают
          } else if (p(j - 1) == '*') {
            dp(i)(j) = dp(i)(j - 2) || // * соответствует 0 символам
              (dp(i - 1)(j) && (s(i - 1) == p(j - 2) || p(j - 2) == '.')) // * соответствует 1 или более символам
          }
        }
      }

      dp(s.length)(p.length) // Возвращаем результат
    }

    println(s"Task 9 = ${solution("aa", "a")}")
    // Task 9 = false

    println(s"Task 9 = ${solution("aa", "a*")}")
    // Task 9 = true

    println(s"Task 9 = ${solution("ab", ".*")}")
    // Task 9 = true

    println(s"Task 9 = ${solution("aab", "c*a*b")}")
    // Task 9 = true

    println(s"Task 9 = ${solution("mississippi", "mis*is*p*.")}")
    // Task 9 = false
  }

  object Task10 {
    def solution(matrix: Array[Array[Int]]): Array[Array[Int]] = {
      val n = matrix.length

      // Транспонируем матрицу
      for (i <- 0 until n) {
        for (j <- i until n) {
          val temp = matrix(i)(j)
          matrix(i)(j) = matrix(j)(i)
          matrix(j)(i) = temp
        }
      }

      // Отражаем каждую строку
      for (i <- 0 until n) {
        for (j <- 0 until n / 2) {
          val temp = matrix(i)(j)
          matrix(i)(j) = matrix(i)(n - 1 - j)
          matrix(i)(n - 1 - j) = temp
        }
      }

      matrix
    }

    val matrix1 = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9)
    )

    val matrix2 = Array(
      Array(5, 1, 9, 11),
      Array(2, 4, 8, 10),
      Array(13, 3, 6, 7),
      Array(15, 14, 12, 16),
    )

    println(s"Task 10 = ${solution(matrix1)}")
    //Task 10 = Array(
    //  Array(7, 4, 1),
    //  Array(8, 5, 2),
    //  Array(9, 6, 3)
    //)

    println(s"Task 10 = ${solution(matrix2)}")
    //Task 10 = Array(
    //  Array(15, 13, 2, 5),
    //  Array(14, 3, 4, 1),
    //  Array(12, 6, 8, 9),
    //  Array(16, 7, 10, 11)
    //)
  }

  object Task11 {
    def solution(nums: Array[Int]): List[List[Int]] = {

      var res = List(List[Int](nums(0)))

      for (n <- nums.slice(1, nums.length)) {
        for(v <- res) {
          for (i <- 0 to v.length) {
            res = res :+ (((v.take(i) :+ n ) ++ v.slice(i, v.length)))
          }
        }
      }
      res.filter(_.length == nums.length)

    }

    println(s"Task 11 = ${solution(Array(1, 2, 3))}")
    // Task 11 = List(
    //   List(1, 2, 3),
    //   List(1, 3, 2),
    //   List(2, 1, 3),
    //   List(2, 3, 1),
    //   List(3, 1, 2),
    //   List(3, 2, 1)
    // )
  }

  object Task12 {
    def solution(s: String): Boolean = {
      s.strip().matches("""^[+-]?(\d+(\.\d*)?|\.\d+)([eE][+-]?\d+)?$""")
    }

    println(s"Task 12 = ${solution("0")}")         // Task 12 = true
    println(s"Task 12 = ${solution(" 0.1 ")}")     // Task 12 = true
    println(s"Task 12 = ${solution("abc")}")       // Task 12 = false
    println(s"Task 12 = ${solution("1 a")}")       // Task 12 = false
    println(s"Task 12 = ${solution("2e10")}")      // Task 12 = true
    println(s"Task 12 = ${solution(" -90e3   ")}") // Task 12 = true
    println(s"Task 12 = ${solution(" 1e")}")       // Task 12 = false
    println(s"Task 12 = ${solution("e3")}")        // Task 12 = false
    println(s"Task 12 = ${solution(" 6e-1")}")     // Task 12 = true
    println(s"Task 12 = ${solution(" 99e2.5 ")}")  // Task 12 = false
    println(s"Task 12 = ${solution("53.5e93")}")   // Task 12 = true
    println(s"Task 12 = ${solution(" --6 ")}")     // Task 12 = false
    println(s"Task 12 = ${solution("-+3")}")       // Task 12 = false
    println(s"Task 12 = ${solution("95a54e53")}")  // Task 12 = false
    println(s"Task 12 = ${solution(".1")}")        // Task 12 = true
    println(s"Task 12 = ${solution("4.")}")        // Task 12 = true
    println(s"Task 12 = ${solution("-.9")}")       // Task 12 = true
    println(s"Task 12 = ${solution("-90E3")}")     // Task 12 = true
  }

  object Task13 {
    def solution(s: String): List[String] = {
      val result = scala.collection.mutable.ListBuffer[String]()
      val n = s.length

      def isValidPart(part: String): Boolean = {
        if (part.isEmpty || (part.length > 1 && part.startsWith("0"))) {
          false
        } else {
          val num = part.toInt
          num >= 0 && num <= 255
        }
      }

      def backtrack(index: Int, parts: List[String]): Unit = {
        if (parts.length == 4) {
          if (index == n) {
            result.append(parts.mkString("."))
          }
          return
        }

        for (i <- 1 to 3) {
          if (index + i <= n) {
            val part = s.substring(index, index + i)
            if (isValidPart(part)) {
              backtrack(index + i, parts :+ part)
            }
          }
        }
      }

      backtrack(0, List())
      result.toList
    }

    println(s"Task 13 = ${solution("25525511135")}")
    // Task 13 = List("255.255.11.135", "255.255.111.35")

    println(s"Task 13 = ${solution("0000")}")
    // Task 13 = List("0.0.0.0")

    println(s"Task 13 = ${solution("1111")}")
    // Task 13 = List("1.1.1.1")

    println(s"Task 13 = ${solution("010010")}")
    // Task 13 = List("0.10.0.10", "0.100.1.0")

    println(s"Task 13 = ${solution("101023")}")
    // Task 13 = List("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3")

    println(s"Task 13 = ${solution("2552551113500001111010010101023")}")
    // Task 13 = List()
  }

  object Task14 {
    def solution(s: String, wordDict: List[String]): List[String] = {
      wordDict
    }

    println(s"Task 14 = ${solution("catsanddog", List("cat", "cats", "and", "sand", "dog"))}")
    // Task 14 = List(
    //   "cats and dog",
    //   "cat sand dog"
    // )

    println(s"Task 14 = ${solution("pineapplepenapple", List("apple", "pen", "applepen", "pine", "pineapple"))}")
    // Task 14 = List(
    //   "pine apple pen apple",
    //   "pineapple pen apple",
    //   "pine applepen apple"
    // )

    println(s"Task 14 = ${solution("catsandog", List("cats", "dog", "sand", "and", "cat"))}")
    // Task 14 = List()

    println(s"Task 14 = ${solution("abcd", List("a", "abc", "b", "cd"))}")
    // Task 14 = List(a b cd)
  }
}
