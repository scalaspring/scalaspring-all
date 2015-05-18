import sbt._
import Keys._

object AllBuild extends Build {
	  
	lazy val ScalaSpringAll = project in file(".") aggregate(ScalaTestSpring, AkkaSpringBoot, AkkaHttpSpringBoot, AkkaHttpSpringBootActivator)
	ScalaSpringAll.settings(
		publish := {},
    scalacOptions       ++= Seq("-feature", "-deprecation")
  )

	lazy val ScalaTestSpring = project in file("scalatest-spring")

	lazy val AkkaSpringBoot = project in file("akka-spring-boot") dependsOn (ScalaTestSpring % "test->compile")

	lazy val AkkaHttpSpringBoot = project in file("akka-http-spring-boot") dependsOn (AkkaSpringBoot, ScalaTestSpring % "test->compile")

	lazy val AkkaHttpSpringBootActivator = project in file("akka-http-spring-boot-activator") dependsOn (AkkaHttpSpringBoot, ScalaTestSpring % "test->compile")

}