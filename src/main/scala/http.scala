package org.decaf.httplist

sealed trait RequestPartial

sealed trait HttpVerb extends RequestPartial
case object Get extends HttpVerb
case object Put extends HttpVerb
case object Post extends HttpVerb
case object Delete extends HttpVerb

case class Url(url: String) extends HttpVerb
object Url {
  def empty = Url("")
}

final case class Header(key: String, value: String) extends RequestPartial
final case class PostParam(key: String, value: String) extends RequestPartial
final case class QueryParam(key: String, value: String) extends RequestPartial

case class HttpRequest(
  verb: HttpVerb,
  url: Url = Url.empty,
  headers: Set[Header] = Set.empty,
  queryParams: Set[QueryParam] = Set.empty,
  postParams: Set[PostParam] = Set.empty
) {
  def add(verb: HttpVerb = this.verb,
          url: Url = this.url,
          headers: Set[Header] = this.headers,
          queryParams: Set[QueryParam] = this.queryParams,
          postParams: Set[PostParam] = this.postParams) =
    this.copy(
      verb = verb,
      url = url,
      headers = headers,
      queryParams = queryParams,
      postParams = postParams
    )
}
