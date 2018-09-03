package me.gion.tagless_final.initial

object Flattening {
  def flata(exp: Exp): Exp = exp match {
    case e @ Lit(_) || Neg(_) => e
    case Add(Add(e1, e2), e3) => flata(Add(e1, Add(e2, e3)))
    case Add(e1, e2) => Add(e1, flata(e2))
  }

  def norm(exp: Exp): Exp = flata(PushingNegation.pushNeg(exp))
}
