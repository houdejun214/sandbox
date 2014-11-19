name := "sandbox"

version := "SNAPSHOT"

organization := "sandbox"

scalaVersion := "2.11.4"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

// Add external conf directory to the classpath
unmanagedClasspath in Test += baseDirectory.value / "conf"

unmanagedClasspath in Runtime += baseDirectory.value / "conf"

resolvers ++= Seq(
  "typesafe.com" at "http://repo.typesafe.com/typesafe/repo/",
  "sonatype.org" at "https://oss.sonatype.org/content/repositories/releases",
  "spray.io" at "http://repo.spray.io"
)

{
  val AkkaVersion = "2.3.7"
  val Json4sVersion = "3.2.11"
  val Log4jVersion = "2.1"
  val ScalaTestVersion = "2.2.1"
  val SlickVersion = "2.1.0"
  val SprayVersion = "1.3.2"
  libraryDependencies ++= Seq(
    "com.googlecode.flyway" % "flyway-core" % "2.3.1",
    "com.github.scopt" %% "scopt" % "3.2.0",
    "com.typesafe.akka" %% "akka-actor" % AkkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
    "com.typesafe" % "config" % "1.2.1",
    "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
    "com.typesafe.slick" %% "slick" % SlickVersion,
    "io.spray" %% "spray-can" % SprayVersion,
    "io.spray" %% "spray-client" % SprayVersion,
    "io.spray" %% "spray-json" % "1.3.1",
    "io.spray" %% "spray-routing" % SprayVersion,
    "net.codingwell" %% "scala-guice" % "4.0.0-beta4",
    "org.apache.logging.log4j" % "log4j-api" % Log4jVersion,
    "org.apache.logging.log4j" % "log4j-core" % Log4jVersion,
    "org.apache.logging.log4j" % "log4j-slf4j-impl" % Log4jVersion,
    "org.json4s" %% "json4s-jackson" % Json4sVersion,
    "org.json4s" %% "json4s-ext" % Json4sVersion,
    //-------------------------------------------------------------------------
    "com.h2database" % "h2" % "1.4.182",
    "com.typesafe.akka" %% "akka-testkit" % AkkaVersion % "test",
    "com.typesafe.slick" %% "slick-testkit" % SlickVersion % "test",
    "io.spray" %% "spray-testkit" % SprayVersion % "test",
    "org.mockito" % "mockito-core" % "1.10.8" % "test",
    "org.scalatest" %% "scalatest" % ScalaTestVersion % "test"
  )
}
