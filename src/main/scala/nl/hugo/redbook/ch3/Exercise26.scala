package nl.hugo.redbook.ch3

object Exercise26 {
  def maximum(t: Tree[Int]): Int =
    t match {
      case Branch(l, r) => maximum(l) max maximum(r)
      case Leaf(v) => v
    }
}