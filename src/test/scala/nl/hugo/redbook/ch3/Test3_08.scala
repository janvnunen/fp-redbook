package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_08 extends WordSpec with Matchers {
  import List.foldRight

  "foldRight" should {

    "return identity when using Nil and Cons" in {
      foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) should be(List(1, 2, 3))
    }
  }
}