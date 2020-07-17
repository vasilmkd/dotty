import quoted._

object Macro_1 {
  inline def foo(inline b: Boolean): Unit = ${fooImpl('b)}
  def fooImpl(b: Expr[Boolean])(using qctx: QuoteContext) : Expr[Unit] =
    if (b.unliftOrError) '{println("foo(true)")}
    else { report.error("foo cannot be called with false"); '{ ??? } }
}
