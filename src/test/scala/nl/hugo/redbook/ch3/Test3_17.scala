package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_17 extends WordSpec with Matchers {

  "toString" should {

    "convert each element of a list to a string" in {
      Exercise17.toString(List(1.0, 2.0, 3.0)) should be(List("1.0", "2.0", "3.0"))
    }

    "return an empty list for an empty list" in {
      Exercise17.toString(Nil) should be(Nil)
    }
  }
}