package nl.hugo.redbook.ch2

import org.scalatest._

class Test2_4 extends WordSpec with Matchers {
  import Exercise04.uncurry

  "uncurry" should {

    "flatten two functions into a single one" in {
      val multiply = (a: Int) => (b: Int) => a * b
      val times = uncurry(multiply)
      times(3, 4) should be(12)
    }
  }
}