import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

    val appName         = "play21-frames-titan-simple-app"
    val appVersion      = "1.0-module-2.3.0-1.0"
	val titanVersion    = "0.3.0"      
  
    val appDependencies = Seq(
    	"com.wingnest.play2" % "play21-frames-titan-plugin_2.10" % "1.0-module-2.3.0-1.0",
	    "com.thinkaurelius.titan" % "titan-berkeleyje" % {titanVersion},
    	javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(
      // Add your own project settings here
      resolvers += "Oracle Releases" at "http://download.oracle.com/maven/"        
    )

}
