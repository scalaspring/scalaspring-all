import sbt._
import Keys._

object AllBuild extends Build {
	  
	lazy val `scalaspring-all` = project in file(".") aggregate(`scalatest-spring`, `akka-spring-boot`, `akka-http-spring-boot`)
	`scalaspring-all`.settings(
		publish := {},
    scalacOptions       ++= Seq("-feature", "-deprecation")
  )

	lazy val `scalatest-spring` = project in file("scalatest-spring")

	lazy val `akka-spring-boot` = project in file("akka-spring-boot") dependsOn (`scalatest-spring` % "test->compile")

	lazy val `akka-http-spring-boot` = project in file("akka-http-spring-boot") dependsOn (`akka-spring-boot`, `scalatest-spring` % "test->compile")

//	lazy val `akka-http-spring-boot-activator` = project in file("akka-http-spring-boot-activator") dependsOn (`akka-http-spring-boot`, `scalatest-spring` % "test->compile")

}