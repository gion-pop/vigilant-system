package me.gion.tagless_final.final_solutions


object Types {
  def varZ(env: (Boolean, _)): Boolean = env._1
  def varS[A, B](vp: A => B)(env: (_, A)): B = vp(env._2)
  def b[A](bv: Boolean)(env: A): Boolean = bv
  def lam[A, B, C](e: ((A, B)) => C)(env: B): A => C = x => e((x, env))
  def app[A, B, C](e1: A => B => C)(e2: A => B)(env: A): C = e1(env)(e2(env))
}
