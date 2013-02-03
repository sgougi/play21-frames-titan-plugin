package services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.formdata.*;
import models.vertices.Log;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.blueprints.Vertex;
import com.tinkerpop.frames.FramedGraph;
import com.tinkerpop.gremlin.groovy.Gremlin;
import com.tinkerpop.gremlin.java.GremlinPipeline;
import com.tinkerpop.pipes.Pipe;
import com.tinkerpop.pipes.PipeFunction;
import com.tinkerpop.pipes.util.structures.Pair;
import com.wingnest.play2.frames.GraphDB;


public class LogService {

	private static final LogService INSTANCE = new LogService();
	
	public static LogService getInstance() {
		return INSTANCE;
	}

	//

	public Log create(LogData logData) {
		final FramedGraph<Graph> fg = GraphDB.createFramedGraph();
		final Date nowDate = new Date();
		Log log = fg.addVertex(null, Log.class);
		/* log */{
			log.setClassName(Log.class.getSimpleName());
			log.setTitle(logData.title);
			log.setName(logData.name);
			log.setLogBody(logData.logBody);
			log.setCreatedDate(nowDate);
			log.setUpdatedDate(nowDate);
		}
		return log;
	}

	public Log findById(Object logId) {
		FramedGraph<Graph> fg = GraphDB.createFramedGraph();
		Log log = fg.getVertex(logId, Log.class);
		return log;
	}

	@SuppressWarnings("rawtypes")
	public Iterable<Log> getLogs() {
		FramedGraph<Graph> graph = GraphDB.createFramedGraph();
		
		GremlinPipeline pipe = new GremlinPipeline();
		Iterable<Vertex> logs = graph.getVertices("className", Log.class.getSimpleName());

		if ( true ) {
			Pipe<Vertex, Vertex> p = Gremlin.compile("_().order({ it.b.createdDate <=> it.a.createdDate })");
			p.setStarts(logs);
			List<Vertex> l = new ArrayList<Vertex>();
			for ( Object o : p )
				l.add((Vertex) o);
			return graph.frameVertices(l, Log.class);
		} else {
			@SuppressWarnings("unchecked")
			final List<Vertex> vertices = pipe.start(logs).order(new PipeFunction<Pair<Vertex, Vertex>, Integer>() {
				public Integer compute(Pair<Vertex, Vertex> pair) {
					Date a = (Date) pair.getA().getProperty("createdDate");
					Date b = (Date) pair.getB().getProperty("createdDate");
					int result = 0;
					if ( a == null && b == null ) {
						result = pair.getA().getId().toString().compareTo(pair.getB().getId().toString());
					} else if ( a == null ) {
						result = -1;
					} else if ( b == null ) {
						result = 1;
					} else {
						result = a.compareTo(b);
					}
					return -result;
				}
			}).toList();
			return graph.frameVertices(vertices, Log.class);
		}
	}

	//

	private LogService() {
	}

}
