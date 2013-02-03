package services;

import java.util.Date;

import models.formdata.*;
import models.vertices.Comment;
import models.vertices.Log;

import com.tinkerpop.blueprints.Graph;
import com.tinkerpop.frames.FramedGraph;
import com.wingnest.play2.frames.GraphDB;


public class CommentService {
	
	private static final CommentService INSTANCE = new CommentService();

	public static CommentService getInstance() {
		return INSTANCE;
	}

	// /

	public Comment create(CommentData commentData, Log log, boolean disupdateFlagLog) {
		final FramedGraph<Graph> fg = GraphDB.createFramedGraph();
		final Date nowDate = new Date();
		Comment comment = fg.addVertex(null, Comment.class);

		/* comment */{
			comment.setClassName(Comment.class.getSimpleName());
			comment.setName(commentData.name);
			comment.setContent(commentData.content);
			comment.setCreatedDate(nowDate);
			comment.setUpdatedDate(nowDate);
		}
		/* log */{
			log.addComment(comment);
			if ( !disupdateFlagLog )
				log.setUpdatedDate(nowDate);
		}
		return comment;
	}

	// /

	private CommentService() {
	}

}
