package models.vertices;

import java.util.Date;

import com.tinkerpop.frames.Property;
import com.wingnest.play2.frames.VertexFrameWithId;
import com.wingnest.play2.frames.annotations.*;
import com.wingnest.play2.frames.annotations.DateProperty.StoreType;

public interface VertexBase extends VertexFrameWithId {

	@DateProperty(value="createdDate", storeType=StoreType.STRING)
	public void setCreatedDate(Date createdDate);

	@DateProperty(value="createdDate", storeType=StoreType.STRING)	
	public Date getCreatedDate();

	
	@DateProperty(value="updatedDate", storeType=StoreType.LONG)
	public Date getUpdatedDate();

	@DateProperty(value="updatedDate", storeType=StoreType.LONG)	
	public void setUpdatedDate(Date updatedDate);

	@Property("className")
	public String getClassName();

	@Property("className")
	public void setClassName(String className);

}
