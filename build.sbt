name := "http-list"

organization := "org.decaf"

scalaVersion := "2.10.3"

scalacOptions ++= Seq("-feature", "-language:implicitConversions")

libraryDependencies ++= Seq(
 "com.chuusai" % "shapeless_2.10.3" % "2.0.0-M1",
  "org.specs2" %% "specs2" % "2.2.3" % "test"
)
