package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_20 extends WordSpec with Matchers {
  import List.flatMap

  "flatMap" should {

    "combine the mapped results of multiple lists into a single list" in {
      flatMap(List(1, 2, 3))(i => List(i, i)) should be(List(1, 1, 2, 2, 3, 3))
    }

    "combine the empty and non-empty lists into a single list" in {
      def map(i: Int): List[Int] = if (i % 2 == 0) Nil else List(i, i)
      flatMap(List(1, 2, 3))(map) should be(List(1, 1, 3, 3))
    }

    "return an empty list for an empty list" in {
      flatMap(Nil)(i => List(i, i)) should be(Nil)
    }
  }
}