package org.decaf.httplist

trait Monoid[M] {
  def zero: M
  def append(x: M, y: M): M
}

object Monoid {
  def empty[M](implicit m: Monoid[M]): M = m.zero
}
