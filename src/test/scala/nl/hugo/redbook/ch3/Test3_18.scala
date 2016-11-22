package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_18 extends WordSpec with Matchers {
  import List.map

  "map" should {

    "add a number to each element of a list" in {
      map(List(1, 2, 3, 4, 5))(_ + 1) should be(List(2, 3, 4, 5, 6))
    }

    "convert each element of a list to a string" in {
      map(List(1.0, 2.0, 3.0))(_.toString) should be(List("1.0", "2.0", "3.0"))
    }

    "return an empty list for an empty list" in {
      map(Nil: List[Int])(_ * 2) should be(Nil)
    }
  }
}