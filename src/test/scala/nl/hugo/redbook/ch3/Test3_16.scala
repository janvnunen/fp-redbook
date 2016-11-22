package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_16 extends WordSpec with Matchers {
  import Exercise16.add

  "add" should {

    "add a number to each element of a list" in {
      add(1)(List(1, 2, 3, 4, 5)) should be(List(2, 3, 4, 5, 6))
    }

    "return an empty list for an empty list" in {
      add(42)(Nil) should be(Nil)
    }
  }
}