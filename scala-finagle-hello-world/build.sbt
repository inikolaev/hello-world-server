name := "FinagleHelloWorld"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "com.twitter" %% "finagle-http" % "18.2.0",
  "com.typesafe" % "config" % "1.3.2"
)
