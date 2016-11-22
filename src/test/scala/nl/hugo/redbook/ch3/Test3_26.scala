package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_26 extends WordSpec with Matchers {
  import Exercise26.maximum

  "maximum" should {

    "return the maximum value of all leafs of a non-empty tree (left case)" in {
      maximum(Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))) should be(4)
    }

    "return the maximum value of all leafs of a non-empty tree (right case)" in {
      maximum(Branch(Branch(Leaf(4), Leaf(3)), Branch(Leaf(2), Leaf(1)))) should be(4)
    }

    "return the value of the leaf of a tree with one element" in {
      maximum(Leaf(42)) should be(42)
    }
  }
}