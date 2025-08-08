// Даны два не пустых связных списка, представляющих два неотрицательных целых числа.
// Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
// Суммируйте два числа и верните их в виде связанного списка.
//
// Примечание:
// - Два числа не содержат нуля в начале, кроме самого числа 0.


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
