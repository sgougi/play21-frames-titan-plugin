import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

	val appName         = "play21-frames-titan-plugin"
	val appVersion      = "1.0-SNAPSHOT"
	val titanVersion    = "0.2.0"
	val tinkerpopVersion = "2.2.0"  

	val appDependencies = Seq(
	    "com.wingnest.play2" % "play21-frames-module_2.10" % "1.0-SNAPSHOT",
	    "com.thinkaurelius.titan" % "titan" % {titanVersion},
    	    javaCore
	)

	val main = play.Project(appName, appVersion, appDependencies).settings(		
	    organization := "com.wingnest.play2",
	    resolvers += "Oracle Releases" at "http://download.oracle.com/maven/"
	)
	
}
