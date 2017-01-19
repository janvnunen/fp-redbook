package nl.hugo.redbook.ch3

object Exercise07 {
  def foldRightLazy[A, B](as: List[A], z: B)(f: (A, => B) => B): B = as match {
    case Nil => z
    case Cons(h, t) => f(h, foldRightLazy(t, z)(f))
  }
}