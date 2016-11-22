package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_07 extends WordSpec with Matchers {
  import Exercise07.foldRightLazy

  "foldRightLazy" should {

    "halt the recusion prematurely" in {
      var count = 0

      def multiply[A](x: Double, y: => Double): Double = {
        count += 1
        if (x != 0.0) x * y else 0.0
      }

      def product(ns: List[Double]) =
        foldRightLazy(ns, 1.0)(multiply)

      product(List(1.0, 2.0, 0.0, 3.0, 4.0)) should be(0.0)
      count should be(3)
    }
  }
}