package me.gion.tagless_final

package object initial {
  sealed trait Exp
  case class Lit(n: Int) extends Exp
  case class Neg(e: Exp) extends Exp
  case class Add(e1: Exp, e2: Exp) extends Exp
}
