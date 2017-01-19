package nl.hugo.redbook.ch3

object Exercise16 {
  def add(v: Int)(as: List[Int]): List[Int] = as match {
    case Nil => Nil
    case Cons(h, t) => Cons(h + v, add(v)(t))
  }
}