package me.gion.tagless_final

package object finals {
  trait ExpSYM[Repr[_]] {
    def lit(n: Int): Repr[Int]
    def neg(e: Repr[Int]): Repr[Int]
    def add(e1: Repr[Int], e2: Repr[Int]): Repr[Int]
  }

  def lit[Repr[_]](n: Int)(implicit s: ExpSYM[Repr]): Repr[Int] = s.lit(n)
  def neg[Repr[_]](e: Repr[Int])(implicit s: ExpSYM[Repr]): Repr[Int] = s.neg(e)
  def add[Repr[_]](e1: Repr[Int], e2: Repr[Int])(implicit s: ExpSYM[Repr]): Repr[Int] = s.add(e1, e2)

  trait MulSYM[Repr[_]] {
    def mul(e1: Repr[Int], e2: Repr[Int]): Repr[Int]
  }

  def mul[Repr[_]](e1: Repr[Int], e2: Repr[Int])(implicit s: MulSYM[Repr]): Repr[Int] = s.mul(e1, e2)

  case class Eval[T](value: Int) extends AnyVal
  case class View[T](value: String) extends AnyVal
}



