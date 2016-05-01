import sbt._
import ScalaSpringProject._

object Build extends sbt.Build {
	  
	lazy val `scalaspring-all` = project in file(".") aggregate(`scalatest-spring`, `akka-spring-boot`, `akka-http-spring-boot`)

	lazy val `scalatest-spring` = (project in file("scalatest-spring"))
    .withScalaSpringSettings(
      "scalatest-spring",
      "Integrates ScalaTest with Spring to manage test context lifecycle using standard Spring annotations and a stackable Scala trait"
    )

	lazy val `akka-spring-boot` = (project in file("akka-spring-boot"))
    .dependsOn(`scalatest-spring` % "test->compile")
    .withScalaSpringSettings(
      "akka-spring-boot",
      "Scala-based integration of Akka with Spring Boot.\nTwo-way Akka<->Spring configuration bindings and convention over configuration with sensible automatic defaults get your project running quickly."
    )

	lazy val `akka-http-spring-boot` = (project in file("akka-http-spring-boot"))
    .dependsOn(`akka-spring-boot`, `scalatest-spring` % "test->compile")
    .withScalaSpringSettings(
      "akka-http-spring-boot",
      "Integrates Scala Akka HTTP and Spring Boot for rapid, robust service development with minimal configuration.\nPre-configured server components require little more than a route to get a service up and running."
    )

//	lazy val `akka-http-spring-boot-activator` = project in file("akka-http-spring-boot-activator") dependsOn (`akka-http-spring-boot`, `scalatest-spring` % "test->compile")

}