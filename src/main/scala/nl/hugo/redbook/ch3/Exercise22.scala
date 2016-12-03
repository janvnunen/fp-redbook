package nl.hugo.redbook.ch3

object Exercise22 {
  def add(l: List[Int], r: List[Int]): List[Int] =
    (l, r) match {
      case (Cons(hl, tl), Cons(hr, tr)) => Cons(hl + hr, add(tl, tr))
      case _ => Nil
    }
}