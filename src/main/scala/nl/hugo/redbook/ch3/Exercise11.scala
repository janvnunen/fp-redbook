package nl.hugo.redbook.ch3

object Exercise11 {
  def sum(ints: List[Int]): Int = List.foldLeft(ints, 0)(_ + _)

  def product(ds: List[Double]): Double = List.foldLeft(ds, 1.0d)(_ * _)
}