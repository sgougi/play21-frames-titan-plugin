/*
 * Copyright since 2013 Shigeru GOUGI (sgougi@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wingnest.play2.frames.plugin.titan;


import play.Play;

import com.thinkaurelius.titan.core.TitanFactory;
import com.thinkaurelius.titan.core.TitanGraph;
import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.TransactionalGraph.Conclusion;
import com.wingnest.play2.frames.plugin.FramesLogger;
import com.wingnest.play2.frames.plugin.graphManager.AbstractGraphManager;

public class TitanGraphManager extends AbstractGraphManager {

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
	
	@Override
	public void onShutdown() {
	}	
}
