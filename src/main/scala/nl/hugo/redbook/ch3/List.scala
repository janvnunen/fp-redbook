package nl.hugo.redbook.ch3

sealed trait List[+A]

case object Nil extends List[Nothing]

case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0
    case Cons(0.0, _) => 0.0
    case Cons(x, xs) => x * product(xs)
  }

  def apply[A](as: A*): List[A] =
    if (as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))

  // exercise 3.2
  def tail[A](as: List[A]): List[A] =
    as match {
      case Cons(_, t) => t
      case Nil => throw new Exception("tail on an empty List")
    }

  // exercise 3.3
  def setHead[A](as: List[A], head: A): List[A] =
    as match {
      case Cons(_, t) => Cons(head, t)
      case Nil => throw new Exception("setHead on an empty List")
    }

  // exercise 3.4
  def drop[A](as: List[A], n: Int): List[A] =
    as match {
      case Cons(_, t) if n > 0 => drop(t, n - 1)
      case _ => as
    }

  // exercise 3.5
  def dropWhile[A](as: List[A], f: A => Boolean): List[A] =
    as match {
      case Cons(h, t) if f(h) => dropWhile(t, f)
      case _ => as
    }

  // exercise 3.6
  def init[A](as: List[A]): List[A] =
    as match {
      case Cons(h, Nil) => Nil
      case Cons(h, t) => Cons(h, init(t))
      case Nil => throw new Exception("init on an empty List")
    }

  // exercise 3.9
  def length[A](as: List[A]): Int =
    foldRight(as, 0)((_, n) => n + 1)

  // exercise 3.10
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B =
    as match {
      case Nil => z
      case Cons(h, t) => foldLeft(t, f(z, h))(f)
    }

  // exercise 3.12
  def reverse[A](as: List[A]): List[A] =
    foldLeft(as, Nil: List[A])((l, v) => Cons(v, l))

  // exercise 3.13
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B =
    foldLeft(reverse(as), z)((a, b) => f(b, a))

  // exercise 3.14
  def append[A](l: List[A], r: List[A]): List[A] =
    foldRight(l, r)(Cons(_, _))

  // exercise 3.18
  def map[A, B](as: List[A])(f: A => B): List[B] =
    foldRight(as, Nil: List[B])((h, t) => Cons(f(h), t))

  // exercise 3.19
  def filter[A](as: List[A])(p: A => Boolean): List[A] =
    foldRight(as, Nil: List[A])((h, t) => if (p(h)) Cons(h, t) else t)

  // exercise 3.20
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] =
    Exercise15.flatAppend(List.map(as)(f))

  // exercise 3.23
  def zipWith[A, B, C](as: List[A], bs: List[B])(f: (A, B) => C): List[C] =
    (as, bs) match {
      case (Cons(hl, tl), Cons(hr, tr)) => Cons(f(hl, hr), zipWith(tl, tr)(f))
      case _ => Nil
    }

  // exercise 3.24
  def contains[A](as: List[A], a: A): Boolean = ???
}