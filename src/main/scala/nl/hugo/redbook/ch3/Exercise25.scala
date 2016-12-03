package nl.hugo.redbook.ch3

object Exercise25 {
  def size[A](t: Tree[A]): Int =
    t match {
      case Branch(l, r) => size(l) + size(r)
      case Leaf(_) => 1
    }
}