package controllers;

import models.formdata.*;
import models.vertices.Log;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import services.CommentService;
import services.LogService;
import views.html.index;
import views.html.logs;

import com.wingnest.play2.frames.annotations.WithGraphDB;
import static play.data.Form.form;

@WithGraphDB
public class Application extends Controller {

	public static Result index() {
		return ok(index.render());
	}

	public static Result postLog() {
		final Form<LogData> logForm = form(LogData.class).bindFromRequest();
		if ( logForm.hasErrors() ) {
			return badRequest(logForm.errorsAsJson());
		}

		@SuppressWarnings("unused")
		Log log = LogService.getInstance().create(logForm.get());

		return ok();
	}

	public static Result getLogs() {
		LogService logService = LogService.getInstance();
		final Iterable<Log> logModels = logService.getLogs();
		return ok(logs.render(logModels));
	}
	
	public static Result postComment(String logId) {
		final Form<CommentData> commentForm = form(CommentData.class).bindFromRequest();
		if ( commentForm.hasErrors() ) {
			return badRequest(commentForm.errorsAsJson());
		}
		if ( logId == null ) {
			return notFound();
		}

		boolean disupdateFlag = Boolean.parseBoolean(form().bindFromRequest().get("disupdateFlagLog"));
		System.out.println("disupdateddate = " + disupdateFlag);
		
		Log log = LogService.getInstance().findById(logId);
		if ( log == null )
			return notFound();

		CommentService.getInstance().create(commentForm.get(), log, disupdateFlag);

		return ok();
	}

}
