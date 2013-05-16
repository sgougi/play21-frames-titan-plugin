import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

	val appName         = "play21-frames-titan-plugin"
	val appVersion      = "1.1-module-2.3.1-1.0"
	val titanVersion    = "0.3.1"

	val appDependencies = Seq(
	    "com.wingnest.play2" % "play21-frames-module_2.10" % "2.3.1-1.0",
	    "com.thinkaurelius.titan" % "titan-core" % {titanVersion},
   	    javaCore
	)

	val main = play.Project(appName, appVersion, appDependencies).settings(
	    publishArtifact in(Compile, packageDoc) := false,
	    organization := "com.wingnest.play2",
	    resolvers += "Oracle Releases" at "http://download.oracle.com/maven/"
	)
	
}
