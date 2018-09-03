package me.gion.tagless_final.deserialize


sealed trait Tree
case class Leaf(value: String) extends Tree
case class Node(value: String, children: Seq[Tree]) extends Tree


/*
object SymanticsTree {
  implicit val expSYMTree = new ExpSYM[Tree] {
    override def lit(n: Int): Tree = Node("Lit", Leaf(n.toString) :: Nil)

    override def neg(e: Tree): Tree = Node("Neg", e :: Nil)

    override def add(e1: Tree, e2: Tree): Tree = Node("Add", e1 :: e2 :: Nil)
  }
}

object DeserializeProblem {
  def fromTree[Repr](tree: Tree)(implicit s: ExpSYM[Repr]): Try[Repr] = tree match {
    case Node("Lit", Leaf(n) :: Nil) => Try{ n.toInt } map s.lit
    case Node("Neg", e :: Nil) => fromTree(e) map s.neg
    case Node("Add", e1 :: e2 :: Nil) =>
      for { e1Repl <- fromTree(e1); e2Repl <- fromTree(e2) } yield s.add(e1Repl, e2Repl)
  }

  def main(args: Array[String]): Unit = {
    val tf1_tree: Tree = {
      import SymanticsTree._

      add(lit(8), neg(add(lit(1), lit(2))))
    }
    println(tf1_tree)

    {
      import me.gion.tagless_final.finals.SymanticsInt._

      fromTree(tf1_tree).fold(
        t => println(s"Error: ${t.getMessage}"),
        println
      )
    }
  }
}
*/
