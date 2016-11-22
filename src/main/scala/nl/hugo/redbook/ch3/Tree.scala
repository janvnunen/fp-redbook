package nl.hugo.redbook.ch3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {

  def fold[A, B](t: Tree[A])(z: A => B)(f: (B, B) => B): B = ???

  def size[A](t: Tree[A]): Int =
    fold(t)(_ => 1)(_ + _)

  def maximum(t: Tree[Int]): Int =
    fold(t)(identity)(_ max _)

  def depth[A](t: Tree[A]): Int =
    fold(t)(_ => 1)((l, r) => 1 + (l max r))

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] =
    fold[A, Tree[B]](t)(a => Leaf(f(a)))(Branch(_, _))
}