package com.wingnest.play2.frames.plugin.titan;


import play.Play;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.TransactionalGraph.Conclusion;
import com.wingnest.play2.frames.plugin.FramesLogger;
import com.wingnest.play2.frames.plugin.graphManager.GraphManager;

public class TitanGraphManager implements GraphManager {

	private static class GraphHolder {
		static private TitanGraph graph = createGraph();
		static private TitanGraph createGraph() {
			final String propFile = Play.application().configuration().getString("frames.titan.properties.file");
			if(propFile != null){
				try {
					return TitanFactory.open(propFile);
				} catch (Throwable e) {
					e.printStackTrace();
					FramesLogger.error("%s" , e.getMessage());
					for(Throwable ee = e.getCause(); ee != null ; ee = e.getCause()) {
						if( ee.getMessage() != null)
							FramesLogger.error("%s" , ee.getMessage());
						e = ee;					
					}			
					FramesLogger.error("com.wingnest.play2.frames.plugin.titan.TitanGraphManager: exit");
					System.exit(0);
					return null;
				}
			} else {
				return TitanFactory.open("./db");
			}
		}				
	}

	@Override
	public <T extends Graph> T getGraph() {
		return (T)GraphHolder.graph;
	}

	@Override
	public void startTransaction() {/* noop */}

	@Override
	public void stopTransaction(Conclusion conclusion) {
		GraphHolder.graph.stopTransaction(conclusion);		
	}
}
