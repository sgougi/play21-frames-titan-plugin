import play.Application;
import play.GlobalSettings;
import play.Logger;

import com.tinkerpop.blueprints.Vertex;
import com.wingnest.play2.frames.GraphDB;

public class Global extends GlobalSettings {

	public void onStart(Application app) {

		try {
			GraphDB.createKeyIndex("className", Vertex.class);
		} catch (java.lang.UnsupportedOperationException e){
			Logger.info(e.getMessage());
		}

	}

}
