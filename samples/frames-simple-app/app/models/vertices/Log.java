package models.vertices;

import com.tinkerpop.blueprints.Direction;
import com.tinkerpop.frames.Adjacency;
import com.tinkerpop.frames.Property;
import com.tinkerpop.frames.annotations.gremlin.GremlinGroovy;

public interface Log extends VertexBase {

	@Property("title")
	public String getTitle();

	@Property("title")
	public void setTitle(String title);

	@Property("name")
	public String getName();

	@Property("name")
	public void setName(String name);

	@Property("logBody")
	public String getLogBody();

	@Property("logBody")
	public void setLogBody(String logBody);

	@Adjacency(label = "hasComment", direction = Direction.OUT)
	public Iterable<Comment> getComments();

	@Adjacency(label = "hasComment", direction = Direction.OUT)
	public void addComment(Comment comment);

	@Adjacency(label = "hasComment", direction = Direction.OUT)
	public void removeComment(Comment comment);

	@GremlinGroovy("_().out('hasComment').has('className', 'Comment').order({ it.a.createdDate <=> it.b.createdDate })")
	public Iterable<Comment> getCommentsOrderByCreatedDateAsc();

	@GremlinGroovy("_().out('hasComment').has('className', 'Comment').order({ it.b.createdDate <=> it.a.createdDate })")
	public Iterable<Comment> getCommentsOrderByCreatedDateDesc();

}
