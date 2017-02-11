enablePlugins(JavaAppPackaging)

name := "scala-akka-hello-world"
organization := "io.github.inikolaev"
version := "1.0"
scalaVersion := "2.12.1"
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")
assemblyJarName in assembly := "scala-akka-hello-world.jar"

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-actor" % "2.4.16",
    "com.typesafe.akka" %% "akka-stream" % "2.4.16",
    "com.typesafe.akka" %% "akka-http-core" % "10.0.3",
    "com.typesafe.akka" %% "akka-http" % "10.0.3"
  )
}

Revolver.settings
