package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_09 extends WordSpec with Matchers {
  import List.{ length => listLength }

  "length" should {

    "return the number of element of a list" in {
      listLength(List(1, 2, 3, 4, 5)) should be(5)
    }

    "return 0 for an empty list" in {
      listLength(Nil) should be(0)
    }
  }
}