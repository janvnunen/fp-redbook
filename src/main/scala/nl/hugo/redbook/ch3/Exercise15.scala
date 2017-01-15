package nl.hugo.redbook.ch3

object Exercise15 {
  import List.append

  def flatAppend[A](ls: List[List[A]]): List[A] = ls match {
    case Nil         => Nil
    case Cons(x, xs) => append(x, flatAppend(xs))
  }
}
