package nl.hugo.redbook.ch3

object Exercise24 {
  @annotation.tailrec
  def startsWith[A](l: List[A], sub: List[A]): Boolean =
    (l, sub) match {
      case (Cons(hl, _), Cons(hr, _)) if hl != hr => false
      case (Cons(_, tl), Cons(_, tr)) => startsWith(tl, tr)
      case (_, Nil) => true
      case _ => false
    }

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean =
    (sup, sub) match {
      case (_, Nil) => true
      case (Nil, _) => false
      case (Cons(_, t), _) => startsWith(sup, sub) || hasSubsequence(t, sub)
    }
}