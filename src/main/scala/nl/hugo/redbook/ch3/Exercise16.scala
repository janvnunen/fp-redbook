package nl.hugo.redbook.ch3

object Exercise16 {

  def add(v: Int)(as: List[Int]): List[Int] = as match {
    case Nil        => Nil
    case Cons(x,xs) => Cons(x + v, add(v)(xs))
  }

  import List.foldRight
  def addFR(v: Int)(as: List[Int]): List[Int] = foldRight(as, Nil: List[Int])((current, result) => Cons(current + v, result))
}
