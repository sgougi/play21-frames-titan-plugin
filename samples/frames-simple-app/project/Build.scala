import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "play21-frames-titan-simple-app"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
    	"com.wingnest.play2" % "play21-frames-titan-plugin_2.10" % "1.0-SNAPSHOT",
    	javaCore
    )

    val main = play.Project(appName, appVersion, appDependencies).settings(		
      // Add your own project settings here      
    )

}
