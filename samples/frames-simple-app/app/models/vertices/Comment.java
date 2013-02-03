package models.vertices;

import com.tinkerpop.frames.Property;

public interface Comment extends VertexBase {

	@Property("name")
	public String getName();

	@Property("name")
	public void setName(String name);

	@Property("content")
	public String getContent();

	@Property("content")
	public void setContent(String content);

}
