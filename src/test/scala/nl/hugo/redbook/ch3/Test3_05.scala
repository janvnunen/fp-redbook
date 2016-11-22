package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_05 extends WordSpec with Matchers {
  import List.dropWhile

  "dropWhile" should {

    "return the list itself if first element does not satisfy the predicate" in {
      dropWhile[Int](List(1, 2, 3, 4, 5), _ < 0) should be(List(1, 2, 3, 4, 5))
    }

    "return all elements from the first element that does not satisfy the predicate" in {
      dropWhile[Int](List(1, 2, 3, 2, 1), _ < 3) should be(List(3, 2, 1))
    }

    "return an empty list when all elements satisfy the predicate" in {
      dropWhile[Int](List(1, 2, 3, 4, 5), _ > 0) should be(Nil)
    }

    "return an empty list for an empty list" in {
      dropWhile[Int](Nil, _ < 1) should be(Nil)
    }
  }
}