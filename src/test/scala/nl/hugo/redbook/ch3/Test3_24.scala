package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_24 extends WordSpec with Matchers {
  import Exercise24.hasSubsequence

  "hasSubsequence" should {

    "determine that one list is contained in itself" in {
      hasSubsequence(List(1, 2, 3, 4), List(1, 2, 3, 4)) should be(true)
    }

    "determine that one list is contained somwhere in another" in {
      hasSubsequence(List(1, 2, 3, 4), List(2, 3)) should be(true)
    }

    "determine that one list is contained in the init of another" in {
      hasSubsequence(List(1, 2, 3, 4), List(1, 2, 3)) should be(true)
    }

    "determine that one list is contained in the tail of another" in {
      hasSubsequence(List(1, 2, 3, 4), List(4)) should be(true)
    }

    "determine that one list is contained in the middle of another" in {
      hasSubsequence(List(1, 1, 2, 1, 2, 1, 2, 3, 4), List(1, 2, 1, 2, 3)) should be(true)
    }

    "determine that an empty list is contained in another" in {
      hasSubsequence(List(1, 2, 3, 4), Nil) should be(true)
    }

    "determine that an empty list is contained in itself" in {
      hasSubsequence(Nil, Nil) should be(true)
    }

    "determine that one list is not contained in another if it is longer" in {
      hasSubsequence(List(1, 2, 3, 4), List(1, 2, 3, 4, 5)) should be(false)
    }

    "determine that one list is not contained in another if it is reversed" in {
      hasSubsequence(List(1, 2, 3, 4), List(3, 2, 1)) should be(false)
    }

    "determine that one list is not contained in another if it is not" in {
      hasSubsequence(List(1, 2, 3, 4), List(1, 2, 4)) should be(false)
    }

    "determine that one list is not contained in an empty list" in {
      hasSubsequence(Nil, List(1, 2)) should be(false)
    }
  }
}