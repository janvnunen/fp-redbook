package nl.hugo.redbook.ch6

import org.scalatest.{ Matchers, WordSpec }

class Test6_02 extends WordSpec with Matchers {
  "RNG.double" should {
    "convert an integer to a double" in {
      val rng = RNG.Simple(0)
      val mock = RNGMock(1234, rng)

      RNG.double(mock) should be((0.000000574626028537750244140625, rng))
    }
  }
}
