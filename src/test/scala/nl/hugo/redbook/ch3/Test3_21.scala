package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_21 extends WordSpec with Matchers {
  import List.filter

  "filter" should {

    "return all elements that satisfy the predicate" in {
      Exercise21.filter(List(1, 2, 3, 2, 1))(_ > 1) should be(filter(List(1, 2, 3, 2, 1))(_ > 1))
    }

    "return an empty list for an empty list" in {
      Exercise21.filter(Nil)(_ == 2) should be(filter(Nil)(_ == 2))
    }
  }
}