package models.formdata;

import play.data.validation.Constraints.Required;

public class LogData {

	@Required
	public String title;
	@Required
	public String name;
	@Required
	public String logBody;

	//
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogBody() {
		return logBody;
	}
	public void setLogBody(String logBody) {
		this.logBody = logBody;
	}

}
