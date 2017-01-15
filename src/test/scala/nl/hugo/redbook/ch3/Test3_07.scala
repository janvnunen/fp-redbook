package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_07 extends WordSpec with Matchers {
  import Exercise07.foldRightLazy

  "foldRightLazy" should {

    "halt the recursion prematurely" in {
      var count = 0

      def multiply[A](x: Double, y: => Double): Double = {
        count += 1
        // Next line  make sure that when x == 0, that y is not evaluated anymore (because we use second parameter lazily (=> B))
        // This will not work for large lists, because it is not tail-recursive.
        if (x != 0.0) x * y else 0.0
      }

      def product(ns: List[Double]) =
        foldRightLazy(ns, 1.0)(multiply)

      product(List(1.0, 2.0, 0.0, 3.0, 4.0)) should be(0.0)
      count should be(3)
    }
  }
}
