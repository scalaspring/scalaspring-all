import sbt._

object Dependencies {

  // Common versions
  object Version {
    val Akka              = "2.4.4"
    val Spring            = "4.2.5.RELEASE"
    val SpringBoot        = "1.3.3.RELEASE"
    val ScalaLogging      = "3.1.0"
    val Logback           = "1.1.2"
    val ScalaTest         = "2.2.6"
  }

  // Logging
  val ScalaLogging        = "com.typesafe.scala-logging" %% "scala-logging" % Version.ScalaLogging
  val LogbackClassic      = "ch.qos.logback" % "logback-classic" % Version.Logback

  // Akka
  val AkkaActor           = "com.typesafe.akka" %% "akka-actor" % Version.Akka
  val AkkaTestKit         = "com.typesafe.akka" %% "akka-testkit" % Version.Akka
  val AkkaHttpCore        = "com.typesafe.akka" %% "akka-http-core" % Version.Akka
  val AkkaHttpTestKit     = "com.typesafe.akka" %% "akka-http-testkit" % Version.Akka

  // Spring
  val SpringContext       = "org.springframework" % "spring-context" % Version.Spring
  val SpringTest          = "org.springframework" % "spring-test" % Version.Spring

  // Spring Boot
  val SpringBootStarter   = "org.springframework.boot" % "spring-boot-starter" % Version.SpringBoot

}