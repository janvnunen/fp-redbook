package nl.hugo.redbook.ch3

object Exercise07 {
  /*
  It is not possible with a regular foldRight. In

  def foldRight[A,B](as: List[A], z: B)(f: (A, B): B

  the arguments of f are evaluated before entering the function. Since the second argument is the foldRight result of
   the next element, it forces the evaluation. Therefore the second argument must be passed by name, delaying evaluation.
   */

  def foldRightLazy[A, B](as: List[A], z: B)(f: (A, => B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRightLazy(xs, z)(f))
    }
}