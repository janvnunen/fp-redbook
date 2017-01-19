package nl.hugo.redbook.ch4

import scala.{ Either => _, Option => _, Some => _ }

// hide std library `Option`, `Some` and `Either`, since we are writing our own in this chapter

sealed trait Option[+A] {
  // Exercise 4.01
  def map[B](f: A => B): Option[B] =
    this match {
      case Some(v) => Some(f(v))
      case _ => None
    }

  // Exercise 4.01
  def getOrElse[B >: A](default: => B): B =
    this match {
      case Some(v) => v
      case _ => default
    }

  // Exercise 4.01
  def flatMap[B](f: A => Option[B]): Option[B] =
    this.map(f).getOrElse(None)

  // Exercise 4.01
  def orElse[B >: A](ob: => Option[B]): Option[B] =
    this map (Some(_)) getOrElse ob

  // Exercise 4.01
  def filter(f: A => Boolean): Option[A] =
    this flatMap (
      a =>
        if (f(a))
          Some(a)
        else
          None
    )
}

case class Some[+A](get: A) extends Option[A]

case object None extends Option[Nothing]

object Option {
  def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!") // `val y: Int = ...` declares `y` as having type `Int`, and sets it equal to the right hand side of the `=`.
    try {
      val x = 42 + 5
      x + y
    } catch {
      case e: Exception => 43
    } // A `catch` block is just a pattern matching block like the ones we've seen. `case e: Exception` is a pattern that matches any `Exception`, and it binds this value to the identifier `e`. The match returns the value 43.
  }

  def failingFn2(i: Int): Int = {
    try {
      val x = 42 + 5
      x + ((throw new Exception("fail!")): Int) // A thrown Exception can be given any type; here we're annotating it with the type `Int`
    } catch {
      case e: Exception => 43
    }
  }

  def mean(xs: Seq[Double]): Option[Double] =
    if (xs.isEmpty) None
    else Some(xs.sum / xs.length)

  // Exercise 4.02
  def variance(xs: Seq[Double]): Option[Double] =
    mean(xs).flatMap(y => mean(xs.map(x => math.pow(x - y, 2))))

  // Exercise 4.03
  def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
    for {
      v <- a
      w <- b
    } yield f(v, w)

  // Exercise 4.04
  def sequence[A](a: List[Option[A]]): Option[List[A]] =
    a.foldRight[Option[List[A]]](Some(Nil))((a, b) => map2(a, b)(_ :: _))

  // Exercise 4.05
  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] =
    a.foldRight[Option[List[B]]](Some(Nil))((v, l) => map2(f(v), l)(_ :: _))

  // Exercise 4.05
  def sequenceViaTraverse[A](a: List[Option[A]]): Option[List[A]] =
    traverse(a)(x => x)

}