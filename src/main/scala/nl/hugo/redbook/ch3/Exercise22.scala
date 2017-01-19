package nl.hugo.redbook.ch3

object Exercise22 {
  def add(l: List[Int], r: List[Int]): List[Int] = {
    (l, r) match {
      case (Cons(hL, tL), Cons(hR, tR)) => Cons(hL + hR, add(tL, tR))
      case _ => Nil
    }
  }
}