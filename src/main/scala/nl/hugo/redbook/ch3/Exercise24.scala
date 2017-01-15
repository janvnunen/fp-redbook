package nl.hugo.redbook.ch3

object Exercise24 {
  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {

    def compareSubsequence(supSeq: List[A], subSeq: List[A]): Boolean = {
      (supSeq, subSeq) match {
        case (_               , Nil             ) => true
        case (Nil             , _               ) => false
        case (Cons(suph, supt), Cons(subh, subt)) => suph == subh && compareSubsequence(supt, subt)
      }
    }

    (sup,sub) match {
      case (_               , Nil      )                                => true
      case (Nil             , _        )                                => false
      case (Cons(_   , _   ), Cons(_,_)) if compareSubsequence(sup,sub) => true
      case (Cons(suph, supt), Cons(_,_))                                => hasSubsequence(supt,sub)
    }
  }
}
