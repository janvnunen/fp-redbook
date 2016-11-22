package nl.hugo.redbook.ch2

import org.scalatest._

class Test2_2 extends WordSpec with Matchers {
  import Exercise02.isSorted

  "isSorted" should {

    "consider an empty array sorted" in {
      isSorted[Int](Array.empty, _ < _) should be(true)
    }

    "consider an array with 1 element sorted" in {
      isSorted[Int](Array(42), _ < _) should be(true)
    }

    "consider an array with increasing elements sorted" in {
      isSorted[Int](Array(1, 2, 3, 5, 8), _ < _) should be(true)
    }

    "consider an array with duplicate elements unsorted" in {
      isSorted[Int](Array(1, 2, 3, 3, 4, 5), _ < _) should be(false)
    }

    "consider an array with some decreasing elements unsorted" in {
      isSorted[Int](Array(1, 2, 3, 2, 1), _ < _) should be(false)
    }
  }
}