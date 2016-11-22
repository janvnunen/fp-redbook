package nl.hugo.redbook.ch3

import org.scalatest._

class Test3_22 extends WordSpec with Matchers {
  import Exercise22.add

  "add" should {

    "add the elements of two lists into a new list" in {
      add(List(1, 2, 3), List(4, 5, 6)) should be(List(5, 7, 9))
    }

    "add the elements of two lists if the first list is shorter" in {
      add(List(1, 2), List(4, 5, 6)) should be(List(5, 7))
    }

    "add the elements of two lists if the first list is longer" in {
      add(List(1, 2, 3, 4), List(4, 5, 6)) should be(List(5, 7, 9))
    }

    "return an empty list if the first list is empty" in {
      add(Nil, List(4, 5, 6)) should be(Nil)
    }

    "return an empty list if the second list is empty" in {
      add(List(1, 2, 3, 4), Nil) should be(Nil)
    }

    "return an empty list for an empty list" in {
      add(Nil, Nil) should be(Nil)
    }
  }
}