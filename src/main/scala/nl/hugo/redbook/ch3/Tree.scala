package nl.hugo.redbook.ch3

sealed trait Tree[+A]
case class Leaf[A](value: A) extends Tree[A]
case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  // exercise 3.29
  def fold[A, B](t: Tree[A])(z: A => B)(f: (B, B) => B): B = ???

  // exercise 3.29
  def size[A](t: Tree[A]): Int = ???

  // exercise 3.29
  def maximum(t: Tree[Int]): Int = ???

  // exercise 3.29
  def depth[A](t: Tree[A]): Int = ???

  // exercise 3.29
  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = ???
}
