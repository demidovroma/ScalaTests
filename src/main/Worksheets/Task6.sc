// Даны два не пустых связных списка, представляющих два неотрицательных целых числа.
// Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
// Суммируйте два числа и верните их в виде связанного списка.
//
// Примечание:
// - Два числа не содержат нуля в начале, кроме самого числа 0.


  case class ListNode(
                       x: Int = 0,
                       next: Option[ListNode] = None
                     )

def solution(l1: ListNode, l2: ListNode): ListNode = {

  def addNodes(
                n1: Option[ListNode],
                n2: Option[ListNode],
                carry: Int
              ): Option[ListNode] = {
    // все null и нет переноса
    if (n1.isEmpty && n2.isEmpty && carry == 0) {
      None
    } else {
      // значения из узлов или 0
      val x = n1.map(_.x).getOrElse(0)
      val y = n2.map(_.x).getOrElse(0)

      // сумма и перенос
      val sum = carry + x + y
      val newCarry = sum / 10
      val digit = sum % 10

      // следующие узлы
      val next1 = n1.flatMap(_.next)
      val next2 = n2.flatMap(_.next)

      // новый узел и рекурсивно продолжаем
      Some(ListNode(digit, addNodes(next1, next2, newCarry)))
    }
  }

  addNodes(Some(l1), Some(l2), 0).getOrElse(ListNode())
}

  // Тестовые случаи
  println(s"Task 6 = ${solution(ListNode(2, Some(ListNode(4, Some(ListNode(3))))), ListNode(5, Some(ListNode(6, Some(ListNode(4))))))}")
  // Ожидаемый результат: ListNode(7, Some(ListNode(0, Some(ListNode(8, None)))))

  println(s"Task 6 = ${solution(ListNode(), ListNode())}")
  // Ожидаемый результат: ListNode(0, None)

  println(s"Task 6 = ${
    solution(
      ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9))))))))))))),
      ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9)))))))
    )
  }")
  // Ожидаемый результат: ListNode(8, Some(ListNode(9, Some(ListNode(9, Some(ListNode(9, Some(ListNode(0, Some(ListNode(0, Some(ListNode(0, Some(ListNode(1, None)))))))))))))))
