package nl.hugo.redbook.ch3

object Exercise25 {
  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_)     => 1
    case Branch(l,r) => size(l) + size(r)
  }

  // NOTE: the book asks for "the number of nodes (leafs and branches)" That would be:
  def size2[A](t: Tree[A]): Int = t match {
    case Leaf(_)     => 1
    case Branch(l,r) => 1 + size2(l) + size2(r)
  }

}
