package me.gion.tagless_final.finals


object ExpressionProblem {
  def main(args: Array[String]): Unit = {
    {
      import SymanticsEval._

      val tf1: Eval[Int] = add(lit(8), neg(add(lit(1), lit(2))))

      val tfm1: Eval[Int] = add(lit(7), neg(mul(lit(1), lit(2))))

      val tfm2: Eval[Int] = mul(lit(7), tf1)

      println(eval(tf1))
      println(eval(tfm1))
      println(eval(tfm2))
    }
    {
      import SymanticsView._

      val tf1: View[Int] = add(lit(8), neg(add(lit(1), lit(2))))

      val tfm1: View[Int] = add(lit(7), neg(mul(lit(1), lit(2))))

      val tfm2: View[Int] = mul(lit(7), tf1)

      println(view(tf1))
      println(view(tfm1))
      println(view(tfm2))
    }
  }
}