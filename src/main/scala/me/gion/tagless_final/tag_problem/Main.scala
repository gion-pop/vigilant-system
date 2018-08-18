package me.gion.tagless_final.tag_problem

object Main {
  def main(args: Array[String]): Unit = {
    println(eval(test1)(Nil))

    /* **Runtime** error!! */
    // println(eval(test1)(Nil))
    // println(eval(test2)(Nil))
  }

  def lookup(varIn: Var, env: List[Union]): Union = varIn match {
    case VZ => env.head
    case VS(v) => lookup(v, env.tail)
  }

  def eval(exp: Exp)(env: List[Union]): Union = exp match {
    case V(v) => lookup(v, env)
    case B(b) => UBool(b)
    case L(e) => UA(x => eval(e)(x :: env))
    case A(e1, e2) => eval(e1)(env) match {
      case UA(f) => f(eval(e2)(env))
    }
  }

  val test1: Exp = A(L(V(VZ)), B(true))

  // この形だと Apply できずにコケる
  val test2: Exp = A(B(true), B(false))

  // 束縛されていない変数があるのでコケる
  val test3: Exp = A(L(V(VS(VZ))), B(true))
}
