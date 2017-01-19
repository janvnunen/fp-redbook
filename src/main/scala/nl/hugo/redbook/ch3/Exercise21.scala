package nl.hugo.redbook.ch3

object Exercise21 {
  def filter[A](l: List[A])(p: A => Boolean): List[A] = List.flatMap(l)(a => if (p(a)) List(a) else List())
}