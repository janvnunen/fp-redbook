package nl.hugo.redbook.ch2

import org.scalatest._

class Test2_3 extends WordSpec with Matchers {
  import Exercise03.curry

  "curry" should {

    "create a partially applied function" in {
      val times = (x: Int, y: Int) => x * y
      val double = curry(times)(2)
      double(7) should be(14)
    }
  }
}