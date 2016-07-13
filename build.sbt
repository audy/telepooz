lazy val buildSettings = Seq(
  organization := "com.github.nikdon",
  scalaVersion := "2.11.8"
)

lazy val compilerOptions = Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:existentials",
  "-language:higherKinds",
  "-unchecked",
  "-Xfatal-warnings",
  "-Yno-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Xfuture"
)

lazy val baseSettings = Seq(
  scalacOptions ++= compilerOptions ++ Seq(
    "-Ywarn-unused-import"
  ),
  testOptions in Test += Tests.Argument("-oF"),
  scalacOptions in(Compile, console) := compilerOptions,
  scalacOptions in(Compile, test) := compilerOptions,
  resolvers ++= Seq(
    Resolver.sonatypeRepo("releases"),
    Resolver.sonatypeRepo("snapshots")
  )
)

buildSettings ++ baseSettings


lazy val akkaHttpJsonV = "1.7.0"
lazy val circeVersion = "0.5.0-M2"
lazy val akkaVersion = "2.4.8"
lazy val catsV = "0.6.0"
lazy val shapelessVersion = "2.3.1"

lazy val scalaTestV = "2.2.6"
lazy val scalaCheckV = "1.12.5"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats" % catsV,

  "com.typesafe.akka" %% "akka-actor"             % akkaVersion,
  "com.typesafe.akka" %% "akka-http-core"         % akkaVersion,
  "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit"           % akkaVersion,

  "io.circe" %% "circe-core"    % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser"  % circeVersion,
  "de.heikoseeberger" %% "akka-http-circe" % akkaHttpJsonV,

  "com.chuusai" %% "shapeless" % shapelessVersion,

  "org.scalatest"  %% "scalatest"  % scalaTestV  % "test",
  "org.scalacheck" %% "scalacheck" % scalaCheckV % "test"
)
