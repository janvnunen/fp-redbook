package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_10 extends WordSpec with Matchers {
  import List.foldLeft

  "foldLeft" should {

    "fold multiple elements into one from left to right" in {
      foldLeft(List(1, 2, 3), 0)(_ - _) should be(-6)
    }

    "fold Nil into the initial result" in {
      foldLeft(Nil: List[Int], 42)(_ + _) should be(42)
    }
  }
}