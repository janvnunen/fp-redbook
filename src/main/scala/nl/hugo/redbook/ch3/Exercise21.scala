package nl.hugo.redbook.ch3

object Exercise21 {
  def filter[A](l: List[A])(p: A => Boolean): List[A] =
    List.flatMap(l)(i => if (p(i)) List(i) else Nil )
}