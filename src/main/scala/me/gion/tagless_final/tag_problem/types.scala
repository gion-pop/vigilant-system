package me.gion.tagless_final.tag_problem

sealed abstract class Var
case object VZ extends Var
case class VS(value: Var) extends Var

sealed abstract class Exp
case class V(value: Var) extends Exp
case class B(value: Boolean) extends Exp
case class L(value: Exp) extends Exp
case class A(value1: Exp, value2: Exp) extends Exp

sealed abstract class Union
case class UBool(value: Boolean) extends Union
case class UA(value: Union => Union) extends Union
