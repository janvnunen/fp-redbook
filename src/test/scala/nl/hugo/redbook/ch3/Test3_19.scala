package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_19 extends WordSpec with Matchers {
  import List.filter

  "filter" should {

    "return all elements that satisfy the predicate" in {
      filter(List(1, 2, 3, 2, 1))(_ > 1) should be(List(2, 3, 2))
    }

    "return an empty list for an empty list" in {
      filter(Nil)(_ == 2) should be(Nil)
    }
  }
}