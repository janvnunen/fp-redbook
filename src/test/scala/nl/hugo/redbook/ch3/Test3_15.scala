package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_15 extends WordSpec with Matchers {
  import Exercise15.flatAppend

  "flatAppend" should {

    "concatenate multiple non-empty lists" in {
      flatAppend(List(List(1, 2, 3), List(4, 5), List(6))) should be(List(1, 2, 3, 4, 5, 6))
    }

    "concatenate a single non-empty list" in {
      flatAppend(List(List(1, 2, 3))) should be(List(1, 2, 3))
    }

    "concatenate empty and non-empty lists" in {
      flatAppend(List(Nil, List(1, 2, 3), Nil, List(4, 5), Nil)) should be(List(1, 2, 3, 4, 5))
    }

    "concatenate multiple empty lists" in {
      flatAppend(List(Nil, Nil, Nil)) should be(Nil)
    }

    "concatenate no lists" in {
      flatAppend(Nil) should be(Nil)
    }
  }
}