package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_08 extends WordSpec with Matchers {
  import List.foldRight

  "foldRight" should {

    "return identity when using Nil and Cons" in {
      // NOTE: you need to implement exercise 13 before you can run this test
      foldRight(List(1, 2, 3), Nil: List[Int])(Cons(_, _)) should be(List(1, 2, 3))
      // The foldRight is supplied with an empty list (Nil) as starting point,
      // and List(1,2,3) should be right-folded into it using the Cons(h,t) as method.
      // As a result List(1,2,3) should come out.
      //
      // Relationship between foldRight and data constructors of List:
      // the constructor of the list is used as the function to call while folding over the data.
      // As the data will be pushed in from last to first, and the List constructor (Cons(x,y))
      // also puts later added items at the front, we will get the items in the same order.
    }
  }
}
