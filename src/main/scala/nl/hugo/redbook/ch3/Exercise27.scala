package nl.hugo.redbook.ch3

object Exercise27 {
  def depth[A](t: Tree[A]): Int = {
    def branchDepth(t: Tree[A], currentDepth: Int): Int = {
      t match {
        case Leaf(_)      => currentDepth + 1
        case Branch(l, r) => branchDepth(l, currentDepth + 1) max branchDepth(r, currentDepth + 1)
      }
    }
    branchDepth(t, 0)
  }
}
