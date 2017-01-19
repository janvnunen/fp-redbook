package nl.hugo.redbook.ch3

import List.foldRight
import List.append

object Exercise15 {
  def flatAppend[A](ls: List[List[A]]): List[A] =
    foldRight(ls, Nil: List[A])(append(_, _))
}