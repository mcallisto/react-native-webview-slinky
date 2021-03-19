/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.3"
name := "react-native-webview-slinky"
version := "0.1.4"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "~16.9.35",
  "@types/react-native" -> "~0.63.2",
  "react-native-webview" -> "11.0.0"
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

// say we want custom code for slinky
stFlavour := Flavour.SlinkyNative

// focus only on these libraries
stMinimize := Selection.AllExcept("react-native-webview")

// shade into another package
stOutputPackage := "vision.id.rnwebview.facade"

ThisBuild / organization := "vision.id"
ThisBuild / organizationName := "vision.id"
ThisBuild / organizationHomepage := Some(url("http://id.vision/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/mcallisto/react-native-webview-slinky"),
    "scm:git@github.com:mcallisto/react-native-webview-slinky.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "mcallisto",
    name  = "Mario Càllisto",
    email = "mario.callisto@gmail.com",
    url   = url("https://github.com/mcallisto")
  )
)

ThisBuild / description := "react-native-webview bindings for slinky (powered by ScalablyTyped)."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/mcallisto/react-native-webview-slinky"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
