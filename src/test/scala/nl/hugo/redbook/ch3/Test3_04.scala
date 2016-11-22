package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_04 extends WordSpec with Matchers {
  import List.drop

  "drop" should {

    "drop the first element when dropping one element" in {
      drop(List(1, 2, 3, 4, 5), 1) should be(List(2, 3, 4, 5))
    }

    "drop multiple elements" in {
      drop(List(1, 2, 3, 4, 5), 3) should be(List(4, 5))
    }

    "return the list itself when dropping no elements" in {
      drop(List(1, 2, 3), 0) should be(List(1, 2, 3))
    }

    "return an empty list when dropping all elements" in {
      drop(List(1, 2, 3), 3) should be(Nil)
    }

    "return an empty list when dropping more elements than the list contains" in {
      drop(List(1, 2, 3), 4) should be(Nil)
    }

    "return an empty list for an empty list" in {
      drop(Nil, 1) should be(Nil)
    }
  }
}