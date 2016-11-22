package nl.hugo.redbook.ch3

object Exercise01 {
  import List.sum

  val x = List(1, 2, 3, 4, 5) match {
    case Cons(x, Cons(2, Cons(4, _))) => x
    case Nil => 42
    case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => x + y // match
    case Cons(h, t) => h + sum(t)
    case _ => 101
  }
}