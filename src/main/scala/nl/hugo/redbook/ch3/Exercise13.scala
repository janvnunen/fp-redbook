package nl.hugo.redbook.ch3

object Exercise13 {
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = ???

  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = ???
}