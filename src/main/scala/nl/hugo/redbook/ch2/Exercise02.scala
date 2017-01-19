package nl.hugo.redbook.ch2

import scala.annotation.tailrec

object Exercise02 {
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def loop(n: Int): Boolean = {
      if (n >= as.length) true
      else ordered(as(n-1), as(n)) && loop(n+1)
    }

    loop(1)
  }

}