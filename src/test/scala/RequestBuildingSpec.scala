package org.decaf.httplist
import org.specs2.mutable.Specification

object RequestBuildingSpec extends Specification with RequestBuilding {

  "Build a request properly" in {
    val req = Get / "users" ++ header("Key", "Value")
    req === HttpRequest(Get,
                        Url("/users"),
                        Set(Header("Key", "Value")))
  }
}
