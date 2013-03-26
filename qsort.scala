def qs[T <% Ordered[T]](list: List[T]): List[T] = list match {
  case Nil => Nil
  case x::xs =>
    qs(for(y <- xs if y <= x) yield y) ++
    List(x) ++
    qs(for(y <- xs if y > x) yield y)
}