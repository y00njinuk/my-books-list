ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "programming-in-scala",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.17" % "test",
      "org.scalatestplus" %% "scalacheck-1-17" % "3.2.17.0" % "test",
      "junit" % "junit" % "4.13.2" % "test"
    )
  )
