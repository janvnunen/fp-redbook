package nl.hugo.redbook.ch3

import List.foldLeft

object Exercise11 {
  def sum(ints: List[Int]): Int =
    foldLeft(ints, 0)(_ + _)

  def product(ds: List[Double]): Double =
    foldLeft(ds, 1.0)(_ * _)
}