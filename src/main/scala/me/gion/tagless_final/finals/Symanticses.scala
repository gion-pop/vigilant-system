package me.gion.tagless_final.finals

object SymanticsEval {
  implicit object ExpSYMEval extends ExpSYM[Eval] {
    override def lit(n: Int): Eval[Int] = Eval(n)

    override def neg(e: Eval[Int]): Eval[Int] = Eval(-e.value)

    override def add(e1: Eval[Int], e2: Eval[Int]): Eval[Int] = Eval(e1.value + e2.value)
  }

  implicit object MulSYMEval extends MulSYM[Eval] {
    override def mul(e1: Eval[Int], e2: Eval[Int]): Eval[Int] = Eval(e1.value * e2.value)
  }

  def eval(eval: Eval[Int]): Int = eval.value
}

object SymanticsView {
  implicit object ExpSYMView extends ExpSYM[View] {
    override def lit(n: Int): View[Int] = View(n.toString)

    override def neg(e: View[Int]): View[Int] = View(s"(-${e.value})")

    override def add(e1: View[Int], e2: View[Int]): View[Int] = View(s"(${e1.value} + ${e2.value})")
  }

  implicit object MulSYMView extends MulSYM[View] {
    override def mul(e1: View[Int], e2: View[Int]): View[Int] = View(s"(${e1.value} * ${e2.value})")
  }

  def view(view: View[Int]): String = view.value
}

