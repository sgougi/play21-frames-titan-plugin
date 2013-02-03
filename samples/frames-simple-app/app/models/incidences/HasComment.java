package models.incidences;

import java.util.Date;

import models.vertices.Comment;
import models.vertices.Log;

import com.tinkerpop.frames.Domain;
import com.tinkerpop.frames.Range;
import com.wingnest.play2.frames.annotations.DateProperty;

public interface HasComment extends EdgeBase {

	@Domain
	public Log getDomain();

	@Range
	public Comment getComment();

	@DateProperty("createdDate")
	public void setCreatedDate(Date createdDate);

	@DateProperty("createdDate")
	public Date getCreatedDate();
	
}
