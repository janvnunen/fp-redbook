package nl.hugo.redbook.ch2

import org.scalatest._

class Test2_5 extends WordSpec with Matchers {
  import Exercise05.compose

  "compose" should {

    "combine two functions two a new one" in {
      val double = (x: Int) => 2 * x
      val triple = (x: Int) => 3 * x
      val hexuple = compose(double, triple)
      hexuple(7) should be(42)
    }
  }
}