package nl.hugo.redbook.ch2

object Exercise03 {
  def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???
}