package nl.hugo.redbook.ch3

object Exercise28 {
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] =
    t match {
      case Branch(l, r) => Branch(map(l)(f), map(r)(f))
      case Leaf(v) => Leaf(f(v))
    }
}