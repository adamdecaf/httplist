package org.decaf.httplist

trait RequestBuilding {
  implicit final class VerbToReq(verb: HttpVerb) {
    def /(path: String): HttpRequest = HttpRequest(verb, Url.empty) / path
    def ++(partial: RequestPartial) = HttpRequest(verb, Url.empty) ++ partial
  }

  implicit final class RequestPartialOps(req: HttpRequest) {
    def /(path: String): HttpRequest = req.add(url = Url(req.url.url + "/" + path))

    def ++(partial: RequestPartial): HttpRequest = partial match {
      case verb: HttpVerb    => req.add(verb = req.verb)
      case header: Header    => req.add(headers = req.headers + header)
      case post: PostParam   => req.add(postParams = req.postParams + post)
      case query: QueryParam => req.add(queryParams = req.queryParams + query)
    }
  }

  def header(key: String, value: String) = Header(key, value)
  def headers(hs: (String, String)*) = hs.toList.map { case (k, v) => Header(k, v) }

  def postParam(key: String, value: String) = PostParam(key, value)
  def postParams(pps: (String, String)*) = pps.toList.map { case (k, v) => PostParam(k, v) }

  def formField(key: String, value: String) = postParam(key, value)
  def formFields(ffs: (String, String)*) = postParams(ffs: _*)

  def queryParam(key: String, value: String) = QueryParam(key, value)
  def queryParams(qps: (String, String)*) = qps.toList.map { case (k, v) => QueryParam(k, v) }
}
