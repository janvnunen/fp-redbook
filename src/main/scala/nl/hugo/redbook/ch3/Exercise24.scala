package nl.hugo.redbook.ch3

import scala.annotation.tailrec

object Exercise24 {
  @tailrec
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    @tailrec
    def startsWith(a: List[A], b: List[A]): Boolean = {
      (a, b) match {
        case (Cons(hA, tA), Cons(hB, tB)) if (hA == hB) => startsWith(tA, tB)
        case (_, Nil) => true
        case _ => false
      }
    }

    def isEmpty(a: List[A]): Boolean = a match {
      case Nil => true
      case _ => false
    }

    if (startsWith(sup, sub)) {
      true
    } else if (isEmpty(sup)) {
      false
    } else {
      hasSubsequence(List.tail(sup), sub)
    }
  }
}