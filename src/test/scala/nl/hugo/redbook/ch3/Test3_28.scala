package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_28 extends WordSpec with Matchers {
  import Exercise28.map

  "map" should {

    "return a new tree with a function applied to the values of all leafs of a non-empty tree" in {
      map(Branch(Branch(Leaf(1), Leaf(2)), Leaf(3)))(_ * 2) should be(Branch(Branch(Leaf(2), Leaf(4)), Leaf(6)))
    }

    "return a new tree with a funcion applied to the value of the leaf of a tree with one element" in {
      map(Leaf(42))(_ / 6) should be(Leaf(7))
    }
  }
}