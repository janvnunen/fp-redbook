package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_14 extends WordSpec with Matchers {
  import List.{append, appendL}

  "append" should {

    "concatenate two non-empty lists" in {
      append(List(1, 2, 3), List(4, 5, 6)) should be(List(1, 2, 3, 4, 5, 6))
      appendL(List(1, 2, 3), List(4, 5, 6)) should be(List(1, 2, 3, 4, 5, 6))
    }

    "concatenate a non-empty and an empty list" in {
      append(List(1, 2, 3), Nil) should be(List(1, 2, 3))
      appendL(List(1, 2, 3), Nil) should be(List(1, 2, 3))
    }

    "concatenate an empty and a non-empty list" in {
      append(Nil, List(1, 2, 3)) should be(List(1, 2, 3))
      appendL(Nil, List(1, 2, 3)) should be(List(1, 2, 3))
    }

    "concatenate two empty lists" in {
      append(Nil, Nil) should be(Nil)
      appendL(Nil, Nil) should be(Nil)
    }
  }
}
