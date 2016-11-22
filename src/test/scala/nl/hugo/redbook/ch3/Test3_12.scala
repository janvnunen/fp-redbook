package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_12 extends WordSpec with Matchers {
  import List.reverse

  "reverse" should {

    "return all elements of a list backwards" in {
      reverse(List(1, 2, 3, 4, 5)) should be(List(5, 4, 3, 2, 1))
    }

    "return the list itself for a list with on element" in {
      reverse(List(42)) should be(List(42))
    }

    "return an empty list itself for an empty list" in {
      reverse(Nil) should be(Nil)
    }
  }
}