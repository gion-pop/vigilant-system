package me.gion.tagless_final.initial


object ExpressionProblem {
  def eval(exp: Exp): Int = exp match {
    case Lit(n) => n
    case Neg(e) => -eval(e)
    case Add(e1, e2) => eval(e1) + eval(e2)
  }

  def main(args: Array[String]): Unit = {
    val ti1: Exp = Add(Lit(8), Neg(Add(Lit(1), Lit(2))))
  }
}
