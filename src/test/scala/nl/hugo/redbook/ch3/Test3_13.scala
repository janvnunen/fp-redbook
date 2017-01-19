package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_13 extends WordSpec with Matchers {
  import List.{ foldLeft, foldRight }

  "foldRight" should {

    "fold multiple elements into one from right to left" in {
      foldRight(List(1, 2, 3), 0)(_ - _) should be(2)
    }

    "fold Nil into the initial result" in {
      foldRight(Nil: List[Int], 42)(_ + _) should be(42)
    }
  }

  "foldLeft, based on foldRight" should {

    "have the same result as the tail-recursive foldLeft" in {
      Exercise13.foldLeft(List(1, 2, 3), 0)(_ - _) should be(foldLeft(List(1, 2, 3), 0)(_ - _))
    }
  }
  "foldRight, based on foldLeft" should {

    "have the same result as the normal foldRight" in {
      Exercise13.foldRight(List(3, 2, 1), 0)(_ - _) should be(foldRight(List(3, 2, 1), 0)(_ - _))
    }
  }
}