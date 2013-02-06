/*
 * Copyright since 2013 Shigeru GOUGI
 *                              e-mail:  sgougi@gmail.com
 *                              twitter: @igerugo
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


import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.frames.FramedGraph;
import com.wingnest.play2.frames.plugin.PluginBase;
import com.wingnest.play2.frames.plugin.framedgraph.*;

import play.Application;

public class FramesTitanPlugin extends PluginBase {

	public FramesTitanPlugin(final Application application) {
		super(application);
	}

	@Override
	protected <T extends FramedGraph<? extends Graph>> FramedGraphDirector<T> createFramedGraphDirector() {
		return (FramedGraphDirector<T>)new DefaultFramedGraphDirector(new TitanGraphManager());
	}

}
