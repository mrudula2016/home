package office.timesheet.ui;

import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import office.timesheet.service.TimesheetService;

@ManagedBean(name = "Clockify")
public class TimesheetUi {
	@ManagedProperty(value = "#{tss}")
	private TimesheetService timesheetservice;

	private String userNameError = "No value Here";

	private TimesheetDto timesheetDto = new TimesheetDto();

	public void setErrorMsg(boolean userExists) {
		if (userExists) {
			userNameError = "User name already exists";
		} else {
			userNameError = "";
		}
	}

	public void checkUser() {
		// call goes to db to check user existnce, and retrun boolean value.
		boolean dbResult = timesheetservice.checkUserExistence(timesheetDto.getName());
		// use that boolean flag to show the error message by calling setErrorMsg method
		setErrorMsg(dbResult);
	}

	public TimesheetDto getTimesheetDto() {
		return timesheetDto;
	}

	public void setTimesheetDto(TimesheetDto timesheetDto) {
		this.timesheetDto = timesheetDto;
	}

	public TimesheetService getTimesheetservice() {
		return timesheetservice;
	}

	public void setTimesheetservice(TimesheetService timesheetservice) {
		this.timesheetservice = timesheetservice;
	}

	public void addDataUi() throws IOException {
		Boolean result = timesheetservice.addDataService(timesheetDto);
		if (!result) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "User name already exists ", null));
		}

	}

	public void fetchUi() throws IOException {
		Boolean result = timesheetservice.fetchDataService(timesheetDto.getName(), timesheetDto.getPassword());
		if (result) {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/success.jsf");
		} else {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/timesheet-app/failure.jsf");
		}
	}

	public void getNameDataUi() {
		Boolean result = timesheetservice.getNameData(timesheetDto.getName());
	}

	public String getUserNameError() {
		return userNameError;
	}

	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}

}
