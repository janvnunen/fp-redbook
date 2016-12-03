package nl.hugo.redbook.ch3

object Exercise17 {
  def toString(as: List[Double]): List[String] =
    List.foldRight(as, Nil: List[String])((h, t) => Cons(h.toString, t))
}