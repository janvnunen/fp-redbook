package nl.hugo.redbook.ch3

import List._

object Exercise17 {
  def toString(as: List[Double]): List[String] =
    foldRight(as, Nil: List[String])((x, xs) => Cons(x.toString, xs))
}