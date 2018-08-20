package me.gion.tagless_final.final_solutions

import me.gion.tagless_final.final_solutions.Types._

object Main {
  val testf1: Any => Boolean = app(lam(varZ))(b(true))

  // Interpreted as:
  val testf1_1: Any => Boolean = (env: Any) => lam(varZ)(env)(b(true)(env))
  val testf1_2: Any => Boolean = (env: Any) => lam(varZ)(env)(b(true)(env))
  val testf1_3: Any => Boolean = (env: Any) => varZ((b(true)(env), env))
  val testf1_4: Any => Boolean = (env: Any) => (b(true)(env), env)._1
  val testf1_5: Any => Boolean = (env: Any) => b(true)(env)
  val testf1_6: Any => Boolean = (_: Any) => true


  val testf3 = app(lam(varS(varZ)))(b(true)) _


  def main(args: Array[String]): Unit = {
    println(testf1())

    /* **Compile** error !! */
    // println(testf3())
  }

}
