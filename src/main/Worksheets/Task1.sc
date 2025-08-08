// Дан массив чисел и целевое значение.
// Напишите программу, которая будет возвращать индексы 2 чисел, сумма которых равна целевому значению.
//
// Примечание:
// - Для каждого набора входных данных может быть только одно решение
// - Нельзя использовать один и тот же элемент массива дважды

var nums = Array(3, 3, 2, 4)
var target = 6;
// *********************
if (nums.length == 2 && nums.sum == target)
    nums.indices.toArray
else

    nums.indices.foldLeft(nums(0)) { (value, index) =>
        println("index = " + index + " : value = " + value)

        if(value + nums(index+1) == target)
            value

        //if(value ==)

        //value
    //    if (maxReach < index) 0 // Если текущая позиция недостижима, возвращаем 0
    //    else if (maxReach >= nums.length - 1) nums.length-1 // Если уже достигли конца, останавливаемся
    //    else Math.max(maxReach, index + nums(index)) // Обновляем максимальную достижимую позицию


        // Math.max(value, index + nums(index))
    }// == nums.length - 1



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

println(s"Task 1 = ${solution(Array(3, 3, 2), 6).toList}")
// Task 1 = List(0, 1)

println(s"Task 1 = ${solution(Array(3, 3, 2), 6).mkString("Array(", ", ", ")")}")

