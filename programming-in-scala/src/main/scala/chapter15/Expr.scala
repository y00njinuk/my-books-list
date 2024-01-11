package chapter15

sealed class Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class Var(name: String) extends Expr