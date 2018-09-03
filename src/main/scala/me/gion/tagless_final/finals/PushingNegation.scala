package me.gion.tagless_final.finals

object PushingNegation {
  sealed trait Ctx
  case object Pos extends Ctx
  case object Neg extends Ctx

  implicit def expSYMCtx[Repr[_]](implicit s: ExpSYM[Repr]) = new ExpSYM[({type R[T] = Ctx => Repr[T]})#R] {
    override def lit(n: Int): Ctx => Repr[Int] = {
      case Pos => s.lit(n)
      case Neg => s.neg(s.lit(n))
    }

    override def neg(e: Ctx => Repr[Int]): Ctx => Repr[Int] = {
      case Pos => e(Neg)
      case Neg => e(Pos)
    }

    override def add(e1: Ctx => Repr[Int], e2: Ctx => Repr[Int]): Ctx => Repr[Int] =
      ctx => s.add(e1(ctx), e2(ctx))
  }

  implicit def mulSYMCtx[Repr[_]](implicit s: MulSYM[Repr]) = new MulSYM[({type R[T] = Ctx => Repr[T]})#R] {
    override def mul(e1: Ctx => Repr[Int], e2: Ctx => Repr[Int]): Ctx => Repr[Int] =
      ctx => s.mul(e1(ctx), e2(ctx))
  }

  def apply[Repr[_]](e: Ctx => Repr[Int]) = e(Pos)
}


object Main {
  def main(args: Array[String]): Unit = {
    import PushingNegation._

    def tf1[Repr[_]](implicit e: ExpSYM[Repr]): Repr[Int] = {
      add(lit(8), neg(add(lit(1), lit(2))))
    }
    def tf2[Repr[_]](implicit e1: ExpSYM[Repr], e2: MulSYM[Repr]): Repr[Int] = {
      mul(lit(8), neg(add(lit(1), lit(2))))
    }

    {
      import SymanticsView._

      println(PushingNegation(tf1[({type R[T] = Ctx => View[T]})#R]).value)
      println(PushingNegation(tf2[({type R[T] = Ctx => View[T]})#R]).value)
    }
  }
}
