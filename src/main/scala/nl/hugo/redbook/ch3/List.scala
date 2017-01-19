package nl.hugo.redbook.ch3

import scala.annotation.tailrec

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

  def invalidArgumentException(): Nothing = throw new RuntimeException("Invalid argument")

  // exercise 3.2
  def tail[A](as: List[A]): List[A] = as match {
    case Nil => invalidArgumentException()
    case Cons(_, t) => t
  }

  // exercise 3.3
  def setHead[A](as: List[A], head: A): List[A] = as match {
    case Nil => invalidArgumentException()
    case Cons(_, t) => Cons(head, t)
  }

  // exercise 3.4
  @tailrec
  def drop[A](as: List[A], n: Int): List[A] = {
    if (n == 0) {
      as
    } else {
      drop(tail(as), n - 1)
    }
  }

  // exercise 3.5
  @tailrec
  def dropWhile[A](as: List[A], f: A => Boolean): List[A] = as match {
    case Nil => Nil
    case Cons(h, t) if f(h) => dropWhile(t, f)
    case x => x
  }

  // exercise 3.6
  def init[A](as: List[A]): List[A] = {
    @tailrec
    def reverse_helper[A](as: List[A], result: List[A]): List[A] = {
      as match {
        case Nil => result
        case Cons(h, t) => reverse_helper(t, Cons(h, result))
      }
    }
    def reverse(as: List[A]): List[A] = reverse_helper(as, List())
    reverse(tail(reverse(as)))
  }

  // exercise 3.9
  def length[A](as: List[A]): Int = foldRight(as, 0)((_, n: Int) => n + 1)

  // exercise 3.10
  @tailrec
  def foldLeft[A, B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(h, t) => foldLeft(t, f(z, h))(f)
  }

  // exercise 3.12
  def reverse[A](as: List[A]): List[A] = foldLeft(as, List[A]())((acc, h) => Cons(h, acc))

  // exercise 3.13
  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = as match {
    case Nil => z
    case Cons(h, t) => f(h, foldRight(t, z)(f))
  }

  // exercise 3.14
  def append[A](l: List[A], r: List[A]): List[A] = foldRight(l, r)(Cons(_, _))

  // exercise 3.18
  def map[A, B](as: List[A])(f: A => B): List[B] = {
    @tailrec
    def helper(as: List[A], result: List[B]): List[B] = as match {
      case Nil => result
      case Cons(h, t) => helper(t, Cons(f(h), result))
    }
    reverse(helper(as, List()))
  }

  // exercise 3.19
  def filter[A](as: List[A])(p: A => Boolean): List[A] = {
    foldRight(as, List[A]()) {
      (element, result) =>
        if (p(element))
          Cons(element, result)
        else
          result
    }
  }

  // exercise 3.20
  def flatMap[A, B](as: List[A])(f: A => List[B]): List[B] = {
    foldRight(as, List[B]()) {
      (element, result) =>
        {
          List.append(f(element), result)
        }
    }
  }

  // exercise 3.23
  def zipWith[A, B, C](as: List[A], bs: List[B])(f: (A, B) => C): List[C] = {
    @tailrec
    def helper(as: List[A], bs: List[B], result: List[C]): List[C] = {
      (as, bs) match {
        case (Cons(hA, tA), Cons(hB, tB)) => helper(tA, tB, Cons(f(hA, hB), result))
        case _ => result
      }
    }
    reverse(helper(as, bs, List[C]()))
  }

  // exercise 3.24
  def contains[A](as: List[A], a: A): Boolean = ???
}