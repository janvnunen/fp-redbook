package nl.hugo.redbook.ch3

object Exercise13 {
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = List.foldLeft(List.reverse(as), z)((b, a) => f(a, b))

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = List.foldRight(List.reverse(as), z)((a, b) => f(b, a))
}