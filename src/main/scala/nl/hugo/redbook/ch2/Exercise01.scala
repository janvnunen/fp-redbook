package nl.hugo.redbook.ch2

import scala.annotation.tailrec

object Exercise01 {
  def fib(n: Int): Int = {
    @tailrec
    def loop(n: Int, a: Int, b: Int): Int =
      if (n == 0)
        a
      else
        loop(n-1, b, a + b)

    loop(n, 0, 1)
  }
}