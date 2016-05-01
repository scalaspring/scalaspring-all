import sbt._
import Keys._

import Version._

object ScalaSpringProject {

  implicit class ScalaSpringSettings(val project: Project) {
    def withScalaSpringSettings(projectName: String, projectDescription: String): Project = {
      project.settings(net.virtualvoid.sbt.graph.Plugin.graphSettings: _*).
      settings(
        name                := projectName,
        description         := projectDescription,
        version             := projectVersion,
        organization        := "com.github.scalaspring",
        scalaVersion        := "2.11.8",
        crossScalaVersions  := Seq("2.10.6"),
        //javacOptions        := Seq("-source", "1.8", "-target", "1.8"),
        scalacOptions       ++= Seq("-feature", "-deprecation"),
        // Publishing settings
        publishMavenStyle       := true,
        publishArtifact in Test := false,
        pomIncludeRepository := { _ => false },
        publishTo := {
          val nexus = "https://oss.sonatype.org/"
          if (isSnapshot.value)
            Some("snapshots" at nexus + "content/repositories/snapshots")
          else
            Some("releases"  at nexus + "service/local/staging/deploy/maven2")
        },
        pomExtra :=
          <url>http://github.com/scalaspring/{projectName}</url>
            <licenses>
              <license>
                <name>Apache License, Version 2.0</name>
                <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
                <distribution>repo</distribution>
              </license>
            </licenses>
            <scm>
              <url>git@github.com:scalaspring/{projectName}.git</url>
              <connection>scm:git:git@github.com:scalaspring/{projectName}.git</connection>
            </scm>
            <developers>
              <developer>
                <id>lancearlaus</id>
                <name>Lance Arlaus</name>
                <url>http://lancearlaus.github.com</url>
              </developer>
            </developers>
      )
    }
  }

}
