package nl.hugo.redbook.ch3

object Exercise17 {
  def toString(as: List[Double]): List[String] = as match {
    case Nil => Nil
    case Cons(h, t) => Cons(h.toString, toString(t))
  }
}