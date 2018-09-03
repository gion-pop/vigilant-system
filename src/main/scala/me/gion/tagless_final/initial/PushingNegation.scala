package me.gion.tagless_final.initial


object PushingNegation {
  def pushNeg(exp: Exp): Exp = exp match {
    case e @ Lit(_) => e
    case e @ Neg(Lit(_)) => e
    case Neg(Neg(e)) => pushNeg(e)
    case Neg(Add(e1, e2)) => Add(pushNeg(Neg(e1)), pushNeg(Neg(e2)))
    case Add(e1, e2) => Add(pushNeg(e1), pushNeg(e2))
  }

  def main(args: Array[String]): Unit = {
    val ti1 = Add(Lit(8), Neg(Add(Lit(1), Lit(2))))
    val ti1_norm = pushNeg(ti1)
    println(ti1_norm)
    //println(eval(ti1_norm))
  }
}
