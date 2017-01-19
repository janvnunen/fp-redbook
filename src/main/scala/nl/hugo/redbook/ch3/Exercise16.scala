package nl.hugo.redbook.ch3

object Exercise16 {
  def add(v: Int)(as: List[Int]): List[Int] =
    List.foldRight(as, Nil: List[Int])((x, xs) => Cons(x + 1, xs))
}